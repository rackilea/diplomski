Lock lock2 = new ReentrantLock();

try {
    // Blocks until the lock is acquired, just like a `synchronized` statement
    lock2.lock();
    f1();

    synchronized (obj1) {
        f2();
        lock2.unlock();
        obj1.wait();
        lock2.lock();
    }
}
// Use `finally` to make sure the lock is always released, even if an exception is thrown
finally {
    // Exception might have been thrown before current thread could acquire lock again, cannot 
    // unlock then
    if (lock2.isHeldByCurrentThread()) {
        lock2.unlock();
    }
}