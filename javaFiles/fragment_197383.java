public Main {
    public static void main(String[] args) {
        final Transaction T = new Transaction();
        for (int n = 0; n < 10; n++) {
            new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        T.setValueByID(i % 100, i);
                        T.getValueByID(i % 100);
                        if (i % 20 == 0) T.commit();
                    }
                }  
            }).start();
        }
    }
}
class Table {
    static final Record[] table = new Record[100];
    static final ReentrantLock[] locks = new ReentrantLock[table.length];

    static {
        for (int i = 0; i < table.length; i++) {
            locks[i] = new ReentrantLock();
        }

        table[0] = new Record(0, 0);
        table[1] = new Record(1, 10);
        table[2] = new Record(2, 20);
        table[3] = new Record(3, 30);
    }
}
class Transaction {

    private ThreadLocal<Set<ReentrantLock>> locks = new ThreadLocal<Set<ReentrantLock>>() {
        @Override
        protected Set<ReentrantLock> initialValue() {
            return new HashSet<ReentrantLock>();
        }
    };

    private void attainLock(int key) {
        final ReentrantLock lock = Table.locks[key];
        lock.lock();
        locks.get().add(lock);
    }

    private void releaseLock(int key) {
        final ReentrantLock lock = Table.locks[key];
        releaseLock(lock);
    }

    private void releaseLock(ReentrantLock lock) {
        final Set<ReentrantLock> lockSet = locks.get();
        if (!lockSet.contains(lock)) {
            throw new IllegalStateException("");
        }
        lockSet.remove(lock);
        lock.unlock();
    }

    private void releaseLocks() {
        final Set<ReentrantLock> lockSet = new HashSet<ReentrantLock>(locks.get());
        for (ReentrantLock reentrantLock : lockSet) {
            releaseLock(reentrantLock);
        }
    }

    public void setValueByID(int key, int value) {
        attainLock(key);
        Table.table[key].key = key;
        releaseLock(key);
    }

    public int getValueByID(int key) {
        attainLock(key);
        return Table.table[key].key;
    }

    void commit() {
        releaseLocks();
    }
}