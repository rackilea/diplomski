new Handler(Looper.getMainLooper()).postDelayed(new Runnable(){
      @Override
      public void run() {
        httpUrlConnection.disconnect();
      }
    }, 5000);