yourRelativeLayout.setOnTouchListener(new OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){

            //Your stuff here
            return true;
        }
        return false;
    }
});