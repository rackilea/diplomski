@Override
public boolean dispatchTouchEvent(MotionEvent event) {
    switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            break;
        case MotionEvent.ACTION_UP:
            if (event.getX() < width && event.getY() < height) {
                //finger is on the card and fire intent
            }
            break;
    }
    return true;
}