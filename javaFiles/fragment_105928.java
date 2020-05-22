public class QDatabase implements Serializable {
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();
...
    public void add(Object[] object) {
        writeLock.lock();
        try {
            ...
        }
        } finally {
            writeLock.unlock();
        }
    }

    public Object getData(int columntocheck, Object check, int columntoget) {
        readLock.lock();
        try {
            ...
        } finally {
            readLock.unlock();
        }
    }
...