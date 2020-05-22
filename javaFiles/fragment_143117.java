ScheduledFuture<?> future = executor.schedule(new Runnable() {
      public void run() {
         emitter.emit( message );
     }
    }, delay, TimeUnit.MILLISECONDS);
future.cancel(true);  //true if task should be interrupted