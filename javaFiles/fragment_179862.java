class Foo {

    Map<String, String> sharedResource;
    ReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {
         lock.readLock().lock();
         try {
             // read
         } finally {
             lock.readLock().unlock();
         }
    }

    public void add() {
         lock.writeLock().lock();
         try {
             // add
         } finally {
             lock.writeLock().unlock();
         }
    }

    public void remove() {
         lock.writeLock().lock();
         try {
             // remove
         } finally {
             lock.writeLock().unlock();
         }
    }
}