@Override
public boolean onInterceptTouchEvent(MotionEvent event) {
    boolean handled = onTouchEvent(event);
    if (event.getAction() == MotionEvent.ACTION_UP) return handled;
    return false;
}