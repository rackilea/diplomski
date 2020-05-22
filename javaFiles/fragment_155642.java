private OnTouchListener onTouchListener = new OnTouchListener() {

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (v.getId() == R.id.button) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //start loop or background task
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                //do something different
            }
        } 
        return true;
    }
}