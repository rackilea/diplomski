public boolean onTouch(View view, MotionEvent event) {
    if(event.getAction() != MotionEvent.ACTION_UP){
        Point point = new Point();
        point.x = event.getX();
        point.y = event.getY();
        points.add(point);
        invalidate();
        Log.d(TAG, "point: " + point);
        return true;
    }
    return super.onTouchEvent(event);
}