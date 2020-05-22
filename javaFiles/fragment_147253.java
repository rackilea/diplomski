class Account {
    private final Lock lock = new ReentrantLock();
    private final Condition depositOk = lock.newCondition();
    private final Condition withdrawOk = lock.newCondition();

    public void withdraw(amount) {
        lock.lock();
        try {
            while (!accountContainsAtLeast(amount)) {
                withdrawOk.await();
            }
            withdrawLocked(amount);
            depositOK.signal();
        } finally {
            lock.unlock();
        }
    }

    public void deposit(amount) {
        lock.lock();
        try {
            while (!OKtoDeposit(amount)) {
                depositOk.await();
            }
            depositLocked(amount);
            withdrawOK.signal();
        } finally {
            lock.unlock();
        }
    }
}