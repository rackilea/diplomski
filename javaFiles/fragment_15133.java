import java.util.concurrent.locks.Lock;

public class Guard implements AutoCloseable {
    private final Lock lock;

    public Guard(Lock lock) {
        this.lock = lock;
        lock.lock();
    }

    @Override
    public void close() {
        lock.unlock();
    }
}