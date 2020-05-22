public class DaemonThreadFactory implements ThreadFactory {
    private ThreadFactory threadFactory = Executors.defaultThreadFactory();

    public Thread newThread( Runnable runnable ) {
        Thread thread = threadFactory.newThread(runnable);
        thread.setDaemon(true);
        return thread;
    }
}