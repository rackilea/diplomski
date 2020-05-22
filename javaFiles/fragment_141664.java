public class KeepingTime
{
    private volatile int timeTaken;
    private Thread timekeeper;

    public KeepingTime()
    {
        timekeeper = new Thread(new Runnable(){
            public void run()
            {
                try
                {
                    while(true)
                    {
                        Thread.sleep(1000);
                        timeTaken++;
                        if(Thread.interrupted())
                            return;
                    }
                }
                catch(InterruptedException e)
                {
                    return;
                }
            }    //end run
        }); //end thread
        timekeeper.start();
    }    //end constructor

    public void stop()
    {
        timekeeper.interrupt();
    }

    public int timeTaken()
    {
        return timeTaken;
    }
}