public abstract class AbstractBaseRunnable implements Runnable {
    ...
    @Override
    public void run() {
        ... // base work here!
    }
}

public class CacheCleaner extends AbstractBaseRunnable implements BackgroundService {
    ...
    @Override
    public void run() {
        super.run();
        ... // particular work for CacheCleaner here!!
    }
}