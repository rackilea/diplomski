public class DaemonThreadFactory implements ThreadFactory
{

    @Override
    public Thread newThread(final Runnable r)
    {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}