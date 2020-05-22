public class SampleTest
{

    public static void main(String[] args)
    {

        int noOfThreads = 100;
        int maxThreadinQue = 100;

        LinkedBlockingQueue<Runnable> processOneworkQueue = new LinkedBlockingQueue<Runnable>();

        ThreadPoolExecutor processOneThreadPoolExecutor = new ThreadPoolExecutor(noOfThreads, noOfThreads, 0L,
                TimeUnit.SECONDS,

                processOneworkQueue, new ThreadFactory()
                {
                    private AtomicInteger itsCounter = new AtomicInteger();

                    public Thread newThread(Runnable theRunnable)
                    {
                        Thread aThread = new Thread(theRunnable, "theThreadName" + "#" + itsCounter.getAndIncrement());
                        aThread.setDaemon(true);
                        return aThread;
                    }
                });

        LinkedBlockingQueue<Runnable> processTwoworkQueue = new LinkedBlockingQueue<Runnable>();

        ThreadPoolExecutor processTwoThreadPoolExecutor = new ThreadPoolExecutor(noOfThreads, noOfThreads, 0L,
                TimeUnit.SECONDS,

                processTwoworkQueue, new ThreadFactory()
                {
                    private AtomicInteger itsCounter = new AtomicInteger();

                    public Thread newThread(Runnable theRunnable)
                    {
                        Thread aThread = new Thread(theRunnable, "theThreadName" + "#" + itsCounter.getAndIncrement());
                        aThread.setDaemon(true);
                        return aThread;
                    }
                });

        ArrayList<SampleObject> sampleObjects = new ArrayList<SampleObject>();
        sampleObjects.add(new SampleObject());
        sampleObjects.add(new SampleObject());
        sampleObjects.add(new SampleObject());
        sampleObjects.add(new SampleObject());
        sampleObjects.add(new SampleObject());
        sampleObjects.add(new SampleObject());
        sampleObjects.add(new SampleObject());
        sampleObjects.add(new SampleObject());
        sampleObjects.add(new SampleObject());
        sampleObjects.add(new SampleObject());
        sampleObjects.add(new SampleObject());
        sampleObjects.add(new SampleObject());
        sampleObjects.add(new SampleObject());
        sampleObjects.add(new SampleObject());

        while (true)
        {
            Iterator<SampleObject> it = sampleObjects.iterator();
            while (it.hasNext())
            {

                final SampleObject sampleObject = it.next();

                if (sampleObject.getStatus() == 0)
                {
                    if (processOneworkQueue.size() < maxThreadinQue)
                    {
                        processOneThreadPoolExecutor.submit(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                process1(sampleObject);

                            }
                        });
                    }
                }
                else if (sampleObject.getStatus() == 1)
                {
                    if (processTwoworkQueue.size() < maxThreadinQue)
                    {
                        processTwoThreadPoolExecutor.submit(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                process2(sampleObject);

                            }
                        });
                    }
                }
                else if (sampleObject.getStatus() == 2)
                {

                    it.remove();

                }
            }
        }
    }

    static void process1(SampleObject sampleObject)
    {
        System.out.println("process1");
        sampleObject.setStatus(1);

    }

    static void process2(SampleObject sampleObject)
    {
        System.out.println("process2");
        sampleObject.setStatus(2);
    }

}

class SampleObject
{
    int status=0;

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }
}