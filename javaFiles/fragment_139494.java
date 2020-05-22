GestureDetectorCompat mDetector;
mDetector = new GestureDetectorCompat(this, new GestureDetector.SimpleOnGestureListener());

mDetector.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener() {
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        // This is where u add your OnClick event
        startTelIntent();
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Log.d("dtttt", "double tap");
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }
});

telefoonTXT.setOnTouchListener(new View.OnTouchListener() {
     @Override
     public boolean onTouch(View v, MotionEvent event) {
          mDetector.onTouchEvent(event);
          return false;
     }
});