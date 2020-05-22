import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class CompletionServiceTest
{
    public static void main(final String[] args)
    {
        CompletionService<Boolean>  cs = new ExecutorCompletionService<Boolean>(Executors.newFixedThreadPool(1));
        Collection<Worker> tasks = new ArrayList<Worker>(10);
        tasks.add(new Worker(1));
        tasks.add(new Worker(2));
        tasks.add(new Worker(3));
        tasks.add(new Worker(4));
        tasks.add(new Worker(5));
        tasks.add(new Worker(6));

        List<Future<Boolean>> futures = new ArrayList<Future<Boolean>>(tasks.size());
        try
        {
            for (Callable task : tasks)
            {
                futures.add(cs.submit(task));
            }
            for (int t = 0; t < futures.size(); t++)
            {
                System.out.println("Invocation:"+t);
                Future<Boolean> result = cs.poll(10, TimeUnit.SECONDS);
                if(result==null)
                {
                    System.out.println(new Date()+":Worker Timedout:");
                    //So lets cancel the first futures we find that havent completed
                    for(Future future:futures)
                    {
                        System.out.println("Checking future");
                        if(future.isDone())
                        {
                            continue;
                        }
                        else
                        {
                            future.cancel(true);
                            System.out.println("Cancelled");
                            break;
                        }
                    }
                    continue;
                }
                else
                {
                    try
                    {
                        if(result.isDone() && !result.isCancelled() && result.get())
                        {
                            System.out.println(new Date()+":Worker Completed:");
                        }
                        else if(result.isDone() && !result.isCancelled() && !result.get())
                        {
                            System.out.println(new Date()+":Worker Failed");
                        }
                    }
                    catch (ExecutionException ee)
                    {
                        ee.printStackTrace(System.out);
                    }
                }
            }
       }
        catch (InterruptedException ie)
        {
        }
        finally
        {
            //Cancel by interrupting any existing tasks currently running in Executor Service
            for (Future<Boolean> f : futures)
            {
                f.cancel(true);
            }
        }
        System.out.println(new Date()+":Done");
    }
}

class Worker implements Callable<Boolean>
{
    private int number;
    public Worker(int number)
    {
        this.number=number;
    }

    public Boolean call()
        throws InterruptedException
    {
        try
        {
            if(number==3)
            {
                Thread.sleep(50000);
            }
        }
        catch(InterruptedException ie)
        {
            System.out.println("Worker Interuppted");
            throw ie;
        }
        return true;
    }
}