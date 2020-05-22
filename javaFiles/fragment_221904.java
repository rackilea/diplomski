@SuppressLint("ClickableViewAccessibility")
@BindingAdapter("onDrawableEndClick")
fun setOnDrawableEndClick(view: TextView, listener: OnCompoundDrawableClickListener?) {
    val padding = 10
    if (listener != null) {
        view.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                if (view.compoundDrawables[DRAWABLE_RIGHT] == null) return@setOnTouchListener false
                else if (event.rawX >= (view.right - view.compoundDrawables[DRAWABLE_RIGHT].bounds.width() - padding)) {
                    listener.onDrawableEnd()
                    return@setOnTouchListener true
                }
            }
            return@setOnTouchListener false
        }
    }
}