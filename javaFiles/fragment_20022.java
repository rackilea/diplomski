Handler mHandler = new Handler();
    mHandler.postDelayed(new Runnable() {
        @Override public void run() {
            // You can set a flag or if you run your method 
            // on another thread, you can interrupt that thread. 
        }
    }, 5000);