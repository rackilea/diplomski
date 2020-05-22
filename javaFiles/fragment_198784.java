public class MyClass {
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock r = rwLock.readLock();
    private final Lock w = rwLock.writeLock();

    public void master() {
        w.lock();
        // do stuff
        w.unlock();
    }

    public void foo() {
        r.lock();
        // do stuff
        r.unlock();
    }

    public void bar() {
        r.lock();
        // do stuff
        r.unlock();
    }
}