Button button = (Button) findViewById(R.id.my_button);
button.setOnTouchListener(new OnTouchListener() {

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                //start timer here
                break;
            case MotionEvent.ACTION_UP:
                //stop timer
                break;
         }

     }
});