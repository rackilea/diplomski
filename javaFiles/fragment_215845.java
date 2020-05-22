private static Map<Long, Reference<ReentrantLock>> lockCache = new WeakHashMap<>();
private static Map<ReentrantLock, Long> keyCache = new WeakHashMap<>();

public static ReentrantLock getLock(Long i)
{
    ReentrantLock lock = null;
    synchronized(lockCache) {
        Reference<ReentrantLock> old = lockCache.get(i);
        if (old != null)
            lock = old.get();

        // if no lock exists or got cleared from keyCache already but not from lockCache yet
        if (lock == null || !keyCache.containsKey(lock)) {
            /* clone i for avoiding strong references 
               to the map's key besides the Object returend 
               by this method.
           */ 
            Long cacheKey = new Long(i); 
            lock = new ReentrantLock();
            lockCache.remove(cacheKey); // just to be sure
            lockCache.put(cacheKey, new WeakReference<>(lock));
            keyCache.put(lock, cacheKey);
        }                
    }

    return lock;
}