private static final class Value {

    public void update() {

    }

}

private static final class Key {

}

private final class MyReaderThread extends Thread {

    private final Map<Key, Value> allValues;

    public MyReaderThread(Map<Key, Value> allValues) {
        this.allValues = allValues;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            readData();
        }
    }

    private void readData() {
        readLock.lock();
        try {
            for (Value value : allValues.values()) {
                // Do something
            }
        }
        finally {
            readLock.unlock();
        }

    }
}

private final class WriterThread extends Thread {

    private final Map<Key, Value> data = new HashMap<Key, Value>();

    @Override
    public void run() {
        while (!isInterrupted()) {
            writeData();
        }
    }

    private void writeData() {
        writeLock.lock();

        try {
            for (Value value : data.values()) {
                value.update();
            }
        }
        finally {
            writeLock.unlock();
        }
    }
}

private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

private final ReadLock readLock;
private final WriteLock writeLock;

public Thing() {
    readLock = lock.readLock();
    writeLock = lock.writeLock();
}

public void doStuff() {
    WriterThread thread1 = new WriterThread();
    WriterThread thread2 = new WriterThread();

    Map<Key, Value> allValues = new HashMap<Key, Value>();
    allValues.putAll(thread1.data);
    allValues.putAll(thread2.data);
    MyReaderThread thread3 = new MyReaderThread(allValues);

    thread1.start();
    thread2.start();
    thread3.start();
}