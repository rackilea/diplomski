import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PreciseSchedulingTest
{
    public static void main(String[] args)
    {
        long periodMs = 50;
        PreciseSchedulingA a = new PreciseSchedulingA();
        a.setup(periodMs);

        PreciseSchedulingB b = new PreciseSchedulingB();
        b.setup(periodMs);
    }
}

class CallTracker implements Runnable
{
    String name;
    long expectedPeriodMs;
    long baseTimeNs;
    long callTimesNs[];
    int numCalls;
    int currentCall;

    CallTracker(String name, long expectedPeriodMs)
    {
        this.name = name;
        this.expectedPeriodMs = expectedPeriodMs;
        this.baseTimeNs = System.nanoTime();
        this.numCalls = 50;
        this.callTimesNs = new long[numCalls];
    }

    @Override
    public void run()
    {
        callTimesNs[currentCall] = System.nanoTime();
        currentCall++;
        if (currentCall == numCalls)
        {
            currentCall = 0;
            double maxErrorMs = 0;
            for (int i = 1; i < numCalls; i++)
            {
                long ns = callTimesNs[i] - callTimesNs[i - 1];
                double ms = ns * 1e-6;
                double errorMs = ms - expectedPeriodMs;
                if (Math.abs(errorMs) > Math.abs(maxErrorMs))
                {
                    maxErrorMs = errorMs;
                }
                //System.out.println(errorMs);
            }
            System.out.println(name + ", maxErrorMs : " + maxErrorMs);
        }
    }

}

class PreciseSchedulingA
{
    public void setup(long periodMs)
    {
        CallTracker callTracker = new CallTracker("A", periodMs);
        ScheduledExecutorService se = Executors.newScheduledThreadPool(20);
        se.scheduleAtFixedRate(callTracker, periodMs, 
            periodMs, TimeUnit.MILLISECONDS);
    }
}

class PreciseSchedulingB
{
    public void setup(long periodMs)
    {
        CallTracker callTracker = new CallTracker("B", periodMs);

        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while (true)
                {
                    long periodNs = periodMs * 1000 * 1000;
                    long endNs = System.nanoTime() + periodNs;
                    while (System.nanoTime() < endNs) 
                    {
                        // Busy waiting...
                    }
                    callTracker.run();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
}