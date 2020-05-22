View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener()   {
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

    view.animate().alpha(0.2f).setDuration(1000);
    }
};