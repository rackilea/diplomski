View v = //Get your view
v.setOnTouchListener(new OnTouchListener(){
    public boolean onTouch(View v, MotionEvent e){
        return gestureDetector.onTouchEvent(e);
    }
});