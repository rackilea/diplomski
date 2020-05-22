ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1)) {
        @Override
        protected void afterExecute(Runnable r, Throwable t)
        {
            // Do some logging here
            super.afterExecute(r, t);
        }
    };