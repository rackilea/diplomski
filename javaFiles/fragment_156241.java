@Override
public void addMessagesToGroup(Object groupId, Message<?>... messages) {
    Lock lock = this.lockRegistry.obtain(groupId);
    try {
        lock.lockInterruptibly();
        boolean unlocked = false;
        ...
        }
        finally {
            if (!unlocked) {
                lock.unlock();
            }
        }
    }
}