yourBtn.setOnTouchListener(new OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            //code that you want do when pressed
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            //code when touch stoped
        }
        return false;
    }
});