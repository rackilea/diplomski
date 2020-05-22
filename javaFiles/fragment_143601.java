private Object mLock = new Object();
private volatile boolean mLocked = false;

public void lock() {
    mLocked = true;
}

public void unlock() {
    synchronized(mlock) {
        mLocked = false;
        mLock.notify();
    }

}

public void run() {
    ....
            Record r = mQueue.take();
            synchronized(mLock) {
                while (mLocked) {
                    mLock.wait();
                }
            }
            process(r);
}