Handler mHandler;
  Runnable mRunnable;
  void scheduleSyncIn(int aSeconds){
      mHandler = new Handler();
      mRunnable = new Runnable() {

            @Override
            public void run() {
              mHandler.postDelayed(mRunnable, aSeconds);
            }
          };
      mHandler.postDelayed(mRunnable, aSeconds);

  }