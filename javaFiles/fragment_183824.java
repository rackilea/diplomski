ed1.setOnTouchListener(new OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(MotionEvent.ACTION_UP == event.getAction())
            editTextClicked(); // Instead of your Toast
        return false;
    }
});