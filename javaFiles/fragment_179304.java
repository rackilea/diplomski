private final static Lock lock = new ReentrantLock();

@Override
public void callBackFun() {
    lock.lock();
    try {
        // Do things here
    } finally {
        lock.unlock();
    }
}