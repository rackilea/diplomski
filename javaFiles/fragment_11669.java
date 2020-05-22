final int TIME_BETWEEN_RELOAD = 5000;
final Handler myHandler = new Handler();


final Runnable reloadWebViewRunnable = new Runnable() {
    @Override
    public void run() {
        Log.d("run", "running the runnable now");
        // Continue the reload every 5 seconds
        myHandler.postDelayed(this, TIME_BETWEEN_RELOAD);

    }
};
// start the initial reload
myHandler.postDelayed(reloadWebViewRunnable, TIME_BETWEEN_RELOAD);