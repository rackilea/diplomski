wv.setOnTouchListener(new View.OnTouchListener() {

        public boolean onTouch(View v, MotionEvent event) {
            WebView.HitTestResult hr = ((WebView)v).getHitTestResult();

            Log.i(TAG, "getExtra = "+ hr.getExtra() + "\t\t Type=" + hr.getType());
            return false;
        }
    });