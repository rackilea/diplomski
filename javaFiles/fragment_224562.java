import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main
{
    private static int foo(final int arg)
    {
        /* Uncomment to see future get interrupted
        try
        {
            Thread.sleep(2000); 
        }
        catch (InterruptedException e) { } */

        return 1000 + arg;
    }

    public static void main(String[] args)
        throws ExecutionException, InterruptedException
    {
        final ExecutorService executor = Executors.newSingleThreadExecutor();
        final Future<Integer> future = executor.submit(() -> Main.foo(3));

        try
        {
            int result = future.get(1, TimeUnit.SECONDS);
            System.out.println(result);
        }
        catch (TimeoutException e)
        {
            future.cancel(true);
        }

        executor.shutdown();
    }
}