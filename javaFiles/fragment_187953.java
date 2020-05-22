private boolean flag = false;

public void doWait() throws InterruptedException {
    lock.lock();
    try {
        // Loop is necessary to avoid spurious wakeup
        while (!flag) {
            cond.await();
        }
    } finally {
        // Unlock in finally in case exception is thrown
        lock.unlock();
    }
}

public void doNotify() {
    lock.lock();
    try {
        flag = true;
        cond.signalAll();
    } finally {
        lock.unlock();
    }
}