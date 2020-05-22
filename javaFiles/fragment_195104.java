ExecutorService ex = Executors.newFixedThreadPool(1);
    final ExecutorService workersPool = Executors.newCachedThreadPool();

    ex.submit(new Runnable() {
        public void run() {
            try {
                do { 
                    // determine if it's time to start workers
                    if (timeToStartWorkers()) {
                        workersPool.submit(new Worker(...));
                        workersPool.submit(new Worker(...));
                        ...
                    }
                    // sleep till next time
                    Thread.sleep(timeTillNextCheck);
                }
            } catch (InterruptedException e) {
                // handle exception
            }
        }
    });