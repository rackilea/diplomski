class MyData {
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();

    public Data ReadSomething(int id) {
        r.lock();
        try {
            Cursor c = readableDatabase.query(...);
            return c.getString(0);
        } finally {
            r.unlock();
        }
    }

    public void ChangeSomething(int id, int value) {
        w.lock();
        try {
            writeableDatabase.update(...);
        } finally {
            w.unlock();
        }
    }
}