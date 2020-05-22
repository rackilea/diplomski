button.setOnTouchListener(new OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
       if(event.getAction() == MotionEvent.ACTION_DOWN){
            // start recording.
            return true;
        }
        if(event.getAction() == MotionEvent.ACTION_UP){
            // Stop recording and save file
            return true;
        }
        return false;
    }
});