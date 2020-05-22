@Override
    public boolean onTouch(View arg0, MotionEvent event) {
        // TODO Auto-generated method stub
        x = event.getX();
        y = event.getY();

        super.onTouchEvent(event);
        return true;
    }