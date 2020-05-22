import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SignalTest {
    public static void main(String... args) throws InterruptedException {
        for ( int i = 0; i < 2000; i++ ) {
            tryOnce();
        }
    }

    private static void tryOnce() throws InterruptedException {
        final Lock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();

        Thread t = new Thread(new Runnable() {
            public void run() {

                try {
                    lock.lockInterruptibly();
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        t.start();

        Thread.sleep(1);
        lock.lock();
        condition.signal();
        t.interrupt();
        lock.unlock();
    }
}