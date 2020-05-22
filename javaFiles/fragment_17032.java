View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener()   {
@Override
public boolean onTouch(View view, MotionEvent motionEvent) {
    if(motionEvent == MotionEvent.ACTION_DOWN)
        view.animate().alpha(0.2f).setDuration(1000);
    }
};