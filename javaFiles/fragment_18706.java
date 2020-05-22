private MotionEvent touch == null;

@Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction == MotionEvent.ACTION_DOWN){
            if(touch == null)
                 touch = event;

            long duration = android.os.SystemClock.elapsedRealtime() 
            - touch.getDownTime();

            if(duration == THRESHOLD){
               //do something 
            }
       }
     }