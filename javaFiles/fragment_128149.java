final ReadWriteLock lock = new ReentrantReadWriteLock();

public void checkFile(String yourData) {

    lock.readLock().lock();

    boolean toWrite = false;
    // Read the file, check for data and update toWrite accordingly
    lock.readLock().unlock();

    if (toWrite) {
        lock.writeLock().lock();

        // write the data to the file

        lock.writeLock().unlock();
    }
}