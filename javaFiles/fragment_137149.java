//member variable 
 private static volatile boolean isRunning = true;

public static void shutdown()
    {
        running = false;
    }

    public void run()
    {
        while( running )
        {
            //do whatever.
        }