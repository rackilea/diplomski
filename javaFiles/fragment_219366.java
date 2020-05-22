/**
 * Onclick event for Touch Screen
 */
@Override
public boolean onTouchEvent(MotionEvent input) {
    if (input.getAction() == MotionEvent.ACTION_MOVE) {
        float currX = input.getX();
        float currY = input.getY();

        if (!swiping) {
            swiping = true;
            swipeStartY = currY;
            swipeStartX = currX;
        }

        if (swiping) {          
            double newDirection = Math.atan2((currY-ball.getY()),currX-ball.getX());
            ball.setDirection(newDirection);
        }

    } else if (input.getAction() == MotionEvent.ACTION_UP) {
        if (swiping) {
            swiping = false;
        }
    }
}