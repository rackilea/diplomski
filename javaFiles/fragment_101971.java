public class MyBlockingQueue<E> {
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public void put(E e) {
        lock.lock();
        try {
            while (isFull()) notFull.await();
            boolean wasEmpty = isEmpty();
            ...
            if (wasEmpty) notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public E take() {
        lock.lock();
        try {
            while (isEmpty()) notEmpty.await();
            boolean wasFull = isFull();
            ...
            if (wasFull) notFull.signal();
            ...
        } finally {
            lock.unlock();
        }
    }
    ...
}