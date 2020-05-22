class MyThreadPoolExecutor extends ThreadPoolExecutor {
    public MyThreadPoolExecutor {
        super(/*Call one of TheadPoolExecutor constructors*/)
    }

    protected afterExecute(Runnable r, Throwable t) {
        // Notify main thread here
    }
}