// disable scroll on touch
webview.setOnTouchListener(new View.OnTouchListener() {

    public boolean onTouch(View v, MotionEvent event) {
      return (event.getAction() == MotionEvent.ACTION_MOVE);
    }
});