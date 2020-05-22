Handler repeatedHandler = new Handler();
Runnable newRunnable = new Runnable() {
    @Override 
    public void run() {
      //Code for the task that needs to be repeated
      //...
      //...
      repeatedHandler.postDelayed(newRunnable, 500);
    }
  };

button.setOnTouchListener(new OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            repeatedHandler.postDelayed(newRunnable, 500);
            break;
            case MotionEvent.ACTION_UP:
            repeatedHandler.removeCallbacks(newRunnable);
            break;
        }
    }
});