View.OnTouchListener gestureListener = new View.OnTouchListener() {
        public boolean onTouch(View v, MotionEvent event) {
            return gestureScanner.onTouchEvent(event);
        }
    };
    ImageView iview = (ImageView) findViewById(R.id.imageView1);
    iview.setOnTouchListener(gestureListener);