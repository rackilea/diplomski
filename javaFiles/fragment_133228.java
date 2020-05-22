class MyThreadFactory implements ThreadFactory {
    private final ThreadFactory DEFAULT_THREAD_FACTORY = Executors.defaultThreadFactory();

    public Thread newThread(Runnable r) {
        Thread thread = DEFAULT_THREAD_FACTORY.newThread(r);
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        return thread;
    }
};


class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread t, Throwable e) {
        // give this a reference to main so it can call some method to pass e and t back 
    }
}