button.setOnTouchListener(new OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {

        ... do a call to your conversion code here ....

        button.setPressed(true);
        return true;
    }
});