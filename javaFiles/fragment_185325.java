public class TSync {

private final Lock lock = new ReentrantLock();
private final Condition previousThreadDone = lock.newCondition();
private boolean ready = false;  // Guarded by lock

public void waitForPreviousThread() throws InterruptedException {
    lock.lock();
    try {
        while (!ready)
            previousThreadDone.await();
        ready = false;
    } finally {
        lock.unlock();
    }
}

public void signalNextThread() {
    lock.lock();
    try {
        ready = true;
        previousThreadDone.signal();
    } finally {
        lock.unlock();
    }
}

}