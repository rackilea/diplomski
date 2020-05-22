public class DelegatingThreadPool implements ThreadPool {

private int size = 5; //Fix this up if you like
private final ThreadPoolExecutor executor = new ThreadPoolExecutor(size, size,
                                  0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

public boolean runInThread(Runnable runnable) {
    synchronized (executor) {
        if (executor.getActiveCount() == size) {
            return false;
        }
        executor.submit(runnable);
        return true;
    }
}

public int blockForAvailableThreads() {
    synchronized (executor) {
        return executor.getActiveCount();
    }
}

public void initialize() throws SchedulerConfigException {
    //noop
}

public void shutdown(boolean waitForJobsToComplete) {
    //No impl provided for wait, write one if you like
    executor.shutdownNow();
}

public int getPoolSize() {
    return size;
}

public void setInstanceId(String schedInstId) {
    //Do what you like here
}

public void setInstanceName(String schedName) {
    //Do what you like here
}