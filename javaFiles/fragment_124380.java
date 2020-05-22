public static class Locks<R>
{
    private ConcurrentHashMap<R, ReentrantReadWriteLock> locks = new ConcurrentHashMap<>();

    public void lock(R r, Function<ReentrantReadWriteLock, Lock> whichLock)
    {
        locks.compute(r, (key, lock) -> {
            ReentrantReadWriteLock actualLock = lock == null ? new ReentrantReadWriteLock() : lock;
            whichLock.apply(actualLock).lock();
            return actualLock;
        });
    }

    public void unlock(R r, Function<ReentrantReadWriteLock, Lock> whichLock)
    {
        locks.computeIfPresent(r, (key, lock) -> {
            whichLock.apply(lock).unlock();
            return lock; // you could return null here if lock is unlocked (see cleanUp) to remove it immediately
        });
    }

    public void cleanUp()
    {
        for (R r : new ArrayList<>(locks.keySet()))
        {
            locks.computeIfPresent(r, (key, lock) -> locks.get(r).isWriteLocked()
                                                     || locks.get(r).getReadLockCount() != 0 ? lock : null);
        }
    }
}