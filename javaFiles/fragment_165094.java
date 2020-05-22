ReadWriteLock lock = new ReentrantReadWriteLock();

public void sortOperation() {
    lock.readLock().lock();
            // read lock granted, which prevents writeLock to be granted
    try {
        sort(); // This is safe, nobody can write
    } finally {
        lock.readLock().unlock();
    }
}

public void updateOperation() {
    lock.writeLock().lock();
            // Write lock granted, no other writeLock (except to myself) can be granted
            // nor any readLock
    try {
        updateMap(); // Nobody is reading, that's OK.
    } finally {
        lock.writeLock().unlock();
    }
}