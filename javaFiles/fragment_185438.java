Handler mHandler = new Handler();
Runnable startTask = new Runnable() {
         @Override
         public void run() {
            lock = true;
            loader.setVisibility(View.VISIBLE);
        }
    };
Runnable stopTask = new Runnable() {
         @Override
         public void run() {
            lock = false;
            loader.setVisibility(View.GONE);
        }
    };
public void startLoader() {
   mHandler.removeCallbacks(stopTask);
   mHandler.post(startTask);
}

public void stopLoader() {
   mHandler.postDelayed(stopTask, 1000);
}