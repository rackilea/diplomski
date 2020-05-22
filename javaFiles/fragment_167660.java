ScheduledExecutorService scheduler =
    Executors.newSingleThreadScheduledExecutor();

scheduler.scheduleAtFixedRate
      (new Runnable() {
         public void run() {
            // call service
         }
      }, 0, 10, TimeUnit.MINUTES);