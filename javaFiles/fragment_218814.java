public class Synchronizer 
{
    private int nextThread;
    private int maxNumThreads;

    public Synchronizer(int numThreads)
    {
        maxNumThreads = numThreads;
        nextThread = 0;
    }

    public void doSync(int threadId) throws Exception
    {
        synchronized(this)
        {
            while(nextThread != threadId)
            {
                wait();
            }
        }
    }

    public void threadDone(int threadId) throws Exception
    {
        synchronized(this)
        {
            nextThread = (threadId + 1) % maxNumThreads;
            notifyAll();
        }
    }
}