detector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
        @Override
        public boolean onDown(MotionEvent e) {
            return true; // the magic is here
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Ln.d("!!! onDoubleTap");
            return super.onDoubleTap(e);
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            Ln.d("!!! onDoubleTapEvent");
            return super.onDoubleTapEvent(e);
        }
    });

    setOnTouchListener(new OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return detector.onTouchEvent(motionEvent);
        }
    });