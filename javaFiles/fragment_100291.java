mFloatingActionButton.setOnTouchListener(new OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_UP){
            // Do what you want
            return true;
        }
        return true; // consume the event
    }
});