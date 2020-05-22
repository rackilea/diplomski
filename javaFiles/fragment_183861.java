@Bean(destroyMethod = "myCustomShutdown")
public ExecutorService executor(BlockingQueue<Runnable> queue) {
    return new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, queue) {
        public void myCustomShutdown() {
            ...
        }
    };
}