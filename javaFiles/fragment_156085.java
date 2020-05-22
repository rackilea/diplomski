final Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
      @Override
      public void run() {

        //Check something after 60 seconds

        handler.postDelayed(this, 60000); //1000ms = 1seconds * 60
      }
    }, 1); // first trigger 1ms. change this if you want to starts at 60 sec make it 60000