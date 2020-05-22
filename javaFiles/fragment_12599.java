ExecutorService executor = Executors.newCachedThreadPool();
  while(moreRequests) {
    executor.execute(new Runnable() {
      public void run() {
        // perform processing
      }
    });
  }

  // finished submitting all requests for processing. Wait for completion
  executor.shutDown();
  executor.awaitTermination(Long.MAX_VALUE, TimeUnit.Seconds);