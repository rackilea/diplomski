textmail.setOnTouchListener(new View.OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        textmail.setClickable(true);
        textmail.setAlpha(1f);
        return false;
    }
});