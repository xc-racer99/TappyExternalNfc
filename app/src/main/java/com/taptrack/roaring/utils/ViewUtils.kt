package com.taptrack.roaring.utils

import android.app.Activity
import android.content.ContextWrapper
import android.os.Build
import android.support.annotation.StyleRes
import android.view.View
import android.widget.TextView

fun TextView.setTextAppearanceCompat(@StyleRes appearance: Int) {
    if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
        this.setTextAppearance(this.context,appearance)
    } else {
        this.setTextAppearance(appearance)
    }
}

inline fun View.getHostActivity(): Activity? {
    var context = this.context
    while (context is ContextWrapper) {
        if (context is Activity) {
            return context
        }
        context = (context as ContextWrapper).baseContext
    }
    return null
}