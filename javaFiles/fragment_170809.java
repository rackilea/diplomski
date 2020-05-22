private static ApplicationContext CONTEXT;
private static volatile Boolean isServiceInitialized = false;

...

if (!isServiceInitialized || (CONTEXT == null))
{
    synchronized (isServiceInitialized)
    {
        if (!isServiceInitialized)
        {
            initializeTouchPointService();
            isServiceInitialized = true;
        }
    }
}