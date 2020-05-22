Handler mHandler = new Handler(getMainLooper());
    Runnable mRunnable = new Runnable() {
    @Override
        public void run() {
             finish();
            Intent i = new Intent(Splash.this,MainActivity.class);
            startActivity(i);

        }
    };
mHandler.postDelayed(mRunnable, 2000);