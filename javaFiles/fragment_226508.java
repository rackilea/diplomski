@Autowired private ReentrantReadWriteLock lock;

public void someMethod() {

    try {
        lock.writeLock().lock();

        // Do your read & lengthy update here

    } finally {
        lock.writeLock().unlock();
    }   
}