// For example, here is a class using a TreeMap that is expected to be 
// large and concurrently accessed.
class RWDictionary {
    private final Map<String, Data> m = new TreeMap<String, Data>();
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock w = rwl.writeLock();

    // other code left out for brevity

    public void clear() {
        w.lock();  // write lock
        try { m.clear(); } // clear the TreeMap
        finally { w.unlock(); }
    }
}