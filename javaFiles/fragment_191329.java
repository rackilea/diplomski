private Handler handler = new Handler();
private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            // Put your logic here
        }
    };

handler.postDelayed(runnable, INTERVAL_TIME);

handler.removeCallbacks(runnable);