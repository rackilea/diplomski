@Autowired private ReentrantReadWriteLock lock;

public void someMethodThatReads() {

    try {
        lock.readLock().lock();

        // Do your reading here

    } finally {
        lock.readLock().unlock();
    }   
}