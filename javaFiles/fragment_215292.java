private final ReentrantLock mLock = new ReentrantLock();

void conditionalLock() {
    ThreadGroup group = Thread.currentThread().getThreadGroup();
    if (group.equals(groupA) || group.equals(groupB)) {
        mLock.lock();
    }
}