// Create the lock object
private ReentrantReadWriteLock lockSqliteDB = new ReentrantReadWriteLock();

// Called to update the database
public void updateDatabase() {
    try {
        lockSqliteDB.writeLock().lock();

        // Read and update the database here

    } finally {
        sqliteDB.close();
        lockSqliteDB.writeLock().unlock();
    }
}

// Called to read from the database
public void readDatabase() {
    try {
        lockSqliteDB.readLock().lock();

        // Read from the database here

    } finally {
        sqliteDB.close();
        lockSqliteDB.readLock().unlock();
    }
}