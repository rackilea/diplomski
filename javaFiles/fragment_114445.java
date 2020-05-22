public class CountingThreadPoolExecutor extends ThreadPoolExecutor {

protected final CountLatch numRunningTasks = new CountLatch(0);

public CountingThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
        BlockingQueue<Runnable> workQueue) {
    super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
}

@Override
public void execute(Runnable command) {
    numRunningTasks.increment();
    super.execute(command);
}

@Override
protected void afterExecute(Runnable r, Throwable t) {
    numRunningTasks.decrement();
    super.afterExecute(r, t);
}

/**
 * Awaits the completion of all spawned tasks.
 */
public void awaitCompletion() throws InterruptedException {
    numRunningTasks.awaitZero();
}

/**
 * Awaits the completion of all spawned tasks.
 */
public void awaitCompletion(long timeout, TimeUnit unit) throws InterruptedException {
    numRunningTasks.awaitZero(timeout, unit);
}

}