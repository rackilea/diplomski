private static final int SWIPE_DISTANCE_THRESHOLD = 125;
private static final int SWIPE_VELOCITY_THRESHOLD = 75;

// make sure to have implemented GestureDetector.OnGestureListener for these to work.
@Override
public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
        float velocityY) {
    float distanceX = e2.getX() - e1.getX();
    float distanceY = e2.getY() - e1.getY();
    if (Math.abs(distanceX) > Math.abs(distanceY) && Math.abs(distanceX) > 
            SWIPE_DISTANCE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {

        // change picture to
        if (distanceX > 0) {
            // start left increment
        }
        else {  // the left
            // start right increment
        }
    }
}

@Override
public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

    // checks if we're touching for more than 2f. I like to have this implemented, to prevent
    // jerky image motion, when not really moving my finger, but still touching. Optional.
    if (Math.abs(distanceY) > 2 || Math.abs(distanceX) > 2) {  
        if(Math.abs(distanceX) > Math.abs(distanceY)) {
            // move the filter left or right
        }
    }
}