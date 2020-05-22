new Thread() {
  @Override
  public void run() {
    super.run();

    Handler handler = new Handler(Looper.getMainLooper()); //Create a Handler to run on the main/UI Thread like this.
    handler.post(new Runnable() {
      @Override
      public void run() {
        // Your operation on the UI Thread
      }
    });
  }
}.start();