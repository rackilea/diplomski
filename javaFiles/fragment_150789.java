public boolean onTouchEvent(MotionEvent event) {
    switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            listener.onPress(this, event);
            break;
        case MotionEvent.ACTION_MOVE:
            listener.onMove(this, event);
            break;
        case MotionEvent.ACTION_UP:
            listener.onRelease(this, event);
            break;
    }
    //this means that you have "used" this event. The ViewGroup will direct all further associated events straight here.
    return true;
}