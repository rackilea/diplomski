public class MainActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        launchThread("TH1");
        sleep(100);
        launchThread("TH2");
        sleep(20);
        dumpThreadTraces();
    }

    void launchThread(String name)
    {
        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                doThings();
            }
        });

        thread.setName(name);
        thread.start();
    }

    synchronized void doThings()
    {
        sleep(1000);
    }

    void dumpThreadTraces()
    {
        Map<Thread, StackTraceElement[]> traces = Thread.getAllStackTraces();

        Set<Thread> threads = traces.keySet();

        for(Thread th : threads)
        {
            if(th.getName().startsWith("TH"))
            {
                logStackTrace(th, traces.get(th));
            }
        }
    }

    void logStackTrace(Thread thread, StackTraceElement[] stackTrace)
    {
        System.out.printf("thread id=%d name=\"%s\"\n", thread.getId(), thread.getName());
        logStackFrames(stackTrace);
    }

    void logStackFrames(StackTraceElement[] stackTrace)
    {
        for (StackTraceElement frame : stackTrace)
        {
            System.out.printf("    at %s\n", frame.toString());
        }
    }

    void sleep(int millis)
    {
        try
        {
            Thread.sleep(millis);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}