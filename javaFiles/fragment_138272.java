ThreadFactory threadFactory = new ThreadFactory() {
    @Override
    public Thread newThread(final Runnable r) {
        Thread thread = new Thread(r);
        thread.setPriority(Thread.MIN_PRIORITY);
        return thread;
    }
};

ExecutorService exe = Executors.newFixedThreadPool(3, threadFactory);

from("direct:slow")
    .threads()
    .executorService(exe)
    ...