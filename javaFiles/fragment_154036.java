ExecutorService pool = Executors.newFixedThreadPool(poolSize);
  ...


  while (...) {
      final int someParameter = ...
      pool.submit(new Runnable() {
              public void run() {
                  // do something using 'someParameter'
              }
      });
  }