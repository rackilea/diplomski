BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
int threads = Runtime.getRuntime().availableProcessors();
ThreadPoolExecutor executor = new ThreadPoolExecutor(threads, threads,
        0, TimeUnit.MILLISECONDS,
        queue, Executors.defaultThreadFactory(),
        new ThreadPoolExecutor.CallerRunsPolicy());