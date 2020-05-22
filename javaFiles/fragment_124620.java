private Handler handler = new Handler();     

private Runnable actionRunnable = new Runnable() {
    public void run(){
        // your action here
    }
}; 

private void handleKeypress() {
    handler.removeCallbacks(actionRunnable);
    handler.postDelayed(actionRunnable, 1000); 
}