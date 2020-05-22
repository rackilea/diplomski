final Handler handler = new Handler();
    Runnable runnable = new Runnable() {
           @Override
           public void run() {
              L.e("Called");
              handler.postDelayed(this, 7200000);
           }
        };
        handler.postDelayed(runnable, 7200000);