@Override
public boolean onTouchEvent(MotionEvent event) {
    boolean isProcessed = scaleGestureDetector.onTouchEvent(event);

    if (isProcessed) {

        // Handle touch events here...
        switch (event.getAction() & MotionEvent.ACTION_MASK) {

        case MotionEvent.ACTION_DOWN:
            start.set(event.getX(), event.getY());
            tap( event.getX(), event.getY() );
            mode = DRAG_OR_TAP;
            break;
        case MotionEvent.ACTION_POINTER_DOWN:
            break;
        case MotionEvent.ACTION_UP: 
            break;
        case MotionEvent.ACTION_POINTER_UP:
            mode = NONE;
            break;
        case MotionEvent.ACTION_MOVE:
            if (mode == DRAG_OR_TAP) {
                doPan(event.getX() - start.x, event.getY() - start.y);
                start.set(event.getX(), event.getY());
            }
            break;
        }
    }

    myView.scale(currentPan, currentScaleFactor);

    invalidate();
    return true;
}

private void doPan(float panX, float panY) {        
    currentPan.x = currentPan.x + panX;
    currentPan.y = currentPan.y + panY;

}

private void tap(float x, float y) {
    ...
}