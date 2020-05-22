public static ExecutorService newExecutor(Appender<?> appender, int threadPoolSize) {
    final String name = appender.getName();
    return Executors.newFixedThreadPool(threadPoolSize, new ThreadFactory() {

        private final AtomicInteger idx = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName(name + "-" + idx.getAndIncrement());
            thread.setDaemon(true);
            return thread;
        }
    });
}