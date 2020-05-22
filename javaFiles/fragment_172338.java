public class Example {
    private Lock lock = new ReentrantLock();
    private Condition update = lock.newCondition();
    public Example(data) {
        data = new ArrayList<Integer>();
    }

    public int getData(int i) {
        lock.lock();
        try {
            while (data.get(i) == null) {
                update.await();
            }
            return data.get(i);
        } finally {
            lock.unlock();
        }
    }

    public void add(int n) {
        data.add(n);
        update.signal();
    }
}