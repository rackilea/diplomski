myLoginSwitch.setOnTouchListener(new View.OnTouchListener() {
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        myLoginSwitch.setClickable(false);
        myLoginLogoutFunc();
        return false;
    }
});