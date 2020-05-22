@Override
public boolean onTouchEvent(MotionEvent event) {
    float x = event.getX();
    float y = event.getY();

    switch (event.getAction()) {

        case MotionEvent.ACTION_DOWN:
            startTouch(x, y);
            break;

        case MotionEvent.ACTION_MOVE:
            moveTouch(x, y);
            break;

        case MotionEvent.ACTION_UP:
            upTouch();
            break;
    }

    findMinMax((int) x, (int) y); //IMPLEMENTED HERE
    return true;
}