private float mCenterX, mCenterY;
private float direction = 0;
private float sX, sY;
private float startDirection=0;
private void touchStart(float x, float y) {
    mCenterX = this.getWidth() / 2;
    mCenterY = this.getHeight() / 2;
    sX = x;
    sY = y;
}

private void touchMove(float x, float y) {
    // this calculate the angle the image rotate
    float angle = (float) angleBetween2Lines(mCenterX, mCenterY, sX, sY, x,
            y);
    direction = (float) Math.toDegrees(angle) * -1 + startDirection;
    this.invalidate();
}

@Override
protected void onDraw(Canvas canvas) {
    canvas.rotate(direction, mCenterX, mCenterY);
    super.onDraw(canvas);
}

@Override
public boolean onTouchEvent(MotionEvent event) {

    float x = event.getX();
    float y = event.getY();
    switch (event.getAction()) {
    case MotionEvent.ACTION_DOWN:
         // record the start position of finger
        touchStart(x, y);
        break;
    case MotionEvent.ACTION_MOVE:
         // update image angle
        touchMove(x, y);
        break;
    case MotionEvent.ACTION_UP:
        startDirection = direction;
        break;
    }

    return true;
}

public double angleBetween2Lines(float centerX, float centerY, float x1,
        float y1, float x2, float y2) {
    double angle1 = Math.atan2(y1 - centerY, x1 - centerX);
    double angle2 = Math.atan2(y2 - centerY, x2 - centerX);
    return angle1 - angle2;
}