final Handler handler = new Handler();

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Log.d("runnable", "handler invoked just once");
            handler.removeCallbacksAndMessages(null);
        }
    };

    handler.postDelayed(runnable, 2000);
    handler.postDelayed(runnable, 2000); // demo: if this is called multiple times my runnable code wont run