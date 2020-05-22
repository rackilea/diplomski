import java.io.*;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;
import java.lang.Object;

class MyThread extends Thread
{
    boolean isPrime(long n) {
        // Check base cases:
        // n < 2, n is 2 or 3, n is divisible by 2 or 3
        if(n < 2) return false;
        if(n == 2 || n == 3) return true;
        if(n%2 == 0 || n%3 == 0) return false;

        // Check if divisible by all numbers 6k +-1 up to sqrt(n)
        long sqrtN = (long)Math.sqrt(n)+1;
        for(long i = 6L; i <= sqrtN; i += 6) {
            if(n%(i-1) == 0 || n%(i+1) == 0) return false;
        }
        return true;
    }

    String threadName;
    public MyThread(String threadName)
    {
        super(threadName);
        this.threadName = threadName;
    }

    @Override
    public void run()
    {
        long startTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
        boolean isPrime = isPrime(Long.parseLong(threadName));
        long endTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
        System.out.println(threadName + ": " + isPrime + "\tStart time: " + startTime + "\tEnd time: " + endTime + "\tElapsed time: " + (endTime - startTime));
    }
}

class primePar {
    public static void main(String args[]) throws ParseException
    {
        if (args.length == 0){
            System.out.println("No args provided.");
        }
        else
        {
            long startTime = System.nanoTime();

            for(int i=0;i< args.length;i++)
            {
                // try
                // {
                    Thread newThread = new MyThread(args[i]);
                    newThread.start();
                    // newThread.join();
                // }
                // catch (InterruptedException exc)
                // {
                //  System.out.println(exc); 
                // }
            }

            long endTime = System.nanoTime();
            System.out.println("Total time: " + TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + " milliseconds");
        }
    }
}