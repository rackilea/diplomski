ReentrantLock lock = new ReentrantLock();

methodA() {
    ...
    if (lock.tryLock()) {
        try {
            doSomething();
        } finally {
            lock.unlock();
        }
    }
    ...
}