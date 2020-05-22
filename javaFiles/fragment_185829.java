public class MyExecutor extends ThreadPoolExecutor {
    private final Queue<RunnableFuture> activeTasks = 
            new LinkedBlockingQueue<RunnableFuture>();
    ...

    protected void beforeExecute(Thread t, Runnable r) {
        RunnableFuture task = (RunnableFuture)r;
        activeTasks.add(task);
    }

    protected void afterExecute(Thread t, Runnable r) {
        RunnableFuture task = (RunnableFuture)r;
        activeTasks.remove(task);
    }

    public void cancelAllActiveTasks() {
        for (RunnableFuture f: activeTasks) {
            f.cancel(true); // invokes your custom cancellation logic
        }
    }