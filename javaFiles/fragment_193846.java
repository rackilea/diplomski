import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test
{

    public static void main(String[] args) throws InterruptedException
    {
        Executor ex = Executors.newCachedThreadPool();
        for(int i=0;i<100;i++)
        {
            CompletableFuture.runAsync(() -> {          
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
                System.out.println("completed");
            },ex);          
        }
        TimeUnit.SECONDS.sleep(2);
    }
}