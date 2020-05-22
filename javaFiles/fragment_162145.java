ExecutorService threadPool =
    Executors.newFixedThreadPool(10,
      new ThreadFactory() {
        public Thread newThread(final Runnable r) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    openSocketAndStoreInThreadLocal();
                    // our tasks would then get the socket from the thread-local
                    r.run();
                    getSocketFromThreadLocalAndCloseIt();
                }
            });
            return thread;
        }
      }));