final UncaughtExceptionHandler handler = new UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable e) {
                // notify error
            }
        });
        Executor executor = Executors.newFixedThreadPool(1, new ThreadFactory() {
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setUncaughtExceptionHandler(handler);
                return thread;
            }
        });