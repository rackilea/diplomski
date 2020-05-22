class Store
{
    private ReadWriteLock rwlock = new ReentrantReadWriteLock();

    public void write()
    {
       rwlock.writeLock().lock();
       try {
          write to store;
       } finally {
          rwlock.writeLock().unlock();
       }
    }

    public String read()
    {
       rwlock.readLock().lock();
       try {
          read from store;
       } finally {
          rwlock.readLock().unlock();
       }
    }
}