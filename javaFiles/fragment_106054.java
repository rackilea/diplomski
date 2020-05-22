@Override
public Thread newThread(Runnable runnable)
{
    Thread thread = new Thread(runnable);
    thread.setDaemon(true);
    return thread;
}