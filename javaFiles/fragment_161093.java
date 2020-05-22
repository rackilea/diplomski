import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

class Worker implements Runnable {
    private AtomicInteger i;
    private Object lock;
    private int max;
    private int mod;

    Worker(AtomicInteger i_, Object lock_, int max_, int mod_){ 
        this.i   = i_;
        this.lock = lock_;
        this.max  = max_;
        this.mod  = mod_; 
    }

    @Override
    public void run(){
        while (i.get() < max)
        {
            if(i.get() % 2 == mod)
            {
                System.out.print(" " + i.getAndAdd(1));

                synchronized(lock){ lock.notify(); }
            }
            else
            {
                synchronized(lock)
                {
                    try { lock.wait(); }
                    catch (InterruptedException e) { e.printStackTrace(); }
                }
            }
        }
    }
}

public class NumPrintTX
{
   public static void main(String[] args)
    {
        final int max = 31;
        final AtomicInteger i = new AtomicInteger(0);
        ExecutorService dd = Executors.newFixedThreadPool(2);

        final Object lock = new Object();

        dd.execute(new Worker(i, lock, max, 0));
        dd.execute(new Worker(i, lock, max, 1));

        dd.shutdown();
    }    
}