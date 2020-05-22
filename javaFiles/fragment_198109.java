new Thread() {
  HashSet<View> aLotOfViews = new HashSet<>();

  @Override
  public void run() {
    Log.d("test", "Hi, I need a lot of views");

    for (int i = 0; i < 59000; i++) {
      aLotOfViews.add(new View(getApplicationContext()));
      if (i % 1000 == 0) {
        Log.d("test", "I have some views: " + aLotOfViews.size());
      }
    }

    Log.d("test", "I have a lot of views: " + aLotOfViews.size());
  }
}.start();