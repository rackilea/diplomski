class SumTask implements Runnable {
    Lock lock;

    public SumTask(Lock commonLock) {
        this.lock = commonLock;
    }

    public void run() {
        lock.lock();

        int value = sum.intValue() + 1;
        sum = new Integer(value);

        lock.unlock(); // Release the lock
    }

}