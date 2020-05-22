final Thread.UncaughtExceptionHandler DEFAULT_HANDLER = new Thread.UncaughtExceptionHandler() {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            log.error("", e);
        }
    };

    ExecutorService executorService = Executors.newCachedThreadPool(new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setUncaughtExceptionHandler(DEFAULT_HANDLER);
            return t;
        }
    });

    executorService.execute(new Runnable() {
        @Override
        public void run() {
            throw new RuntimeException("log me");
        }
    });