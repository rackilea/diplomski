View.OnTouchListener boxListener = new View.OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        txtHint.setText(hintPrefix + onOneClick);
        return false;
    }
});

//boxes is a list of all your boxes
for(int i=0; i < boxes.size(); i++) {
    boxes.get(i).setOnTouchListener(boxListener);
}