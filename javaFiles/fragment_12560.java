import java.util.concurrent.Callable ;
import java.util.concurrent.atomic.AtomicLong ;

public class MyCountingTask implements Callable<Void> {

    private AtomicLong progressCount = new AtomicLong();
    private final long max = 1000 ;

    @Override
    public Void call() throws InterruptedException {

        for (int count = 0; count < max ; count++) {

            progressCount.set(count);

            // in real life, do actual work instead of sleeping...
            Thread.sleep(100);
        }

        progressCount.set(max);

        return null ;
    }

    public double getProgress() {
        return 1.0*progressCount.get() / max ;
    }
}