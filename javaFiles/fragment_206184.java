ScheduledExecutorService scheduleTaskExecutor = Executors.newScheduledThreadPool(1);

scheduleTaskExecutor.scheduleAtFixedRate(new Runnable() {
  public void run() {
    runOnUiThread(new Runnable() {
      public void run() {
        if (foto.getVisibility == View.VISIBLE) {
            foto.setVisibility(View.INVISIBLE);
            foto1.setVisibility(View.VISIBLE);
        } else {
            foto.setVisibility(View.VISIBLE);
            foto1.setVisibility(View.INVISIBLE);
        }
      }
    });
  }
}, 0, 1, TimeUnit.SECONDS);