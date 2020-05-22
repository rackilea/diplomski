private float xPosition; // set to initial position in onCreate

//OnTouch Function
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int screenWidth = getResources().getDisplayMetrics().widthPixels;
        float x = event.getRawX();
        int durationMs = 50;
        int buffer = 90;
        if ( x >= ( screenWidth/2) && xPosition < screenWidth-buffer ) {
            float XToMove = 85;
            v.animate().translationXBy(XToMove).setDuration(durationMs);
            xPosition += XToMove;
        }else if( x < ( screenWidth/2) && xPosition > buffer ) {
            float XToMove = -60; // or whatever amount you want
            v.animate().translationXBy(XToMove).setDuration(durationMs);
            xPosition += XToMove;
        }
        return false;
    }
});