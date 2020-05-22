Handler mainHandler = new Handler(context.getMainLooper());

Runnable myRunnable = new Runnable() {
    @Override 
    public void run() {
       layout.removeView(textView);
    } 
};
mainHandler.post(myRunnable);