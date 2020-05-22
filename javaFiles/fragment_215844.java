private static Map<Long, Reference<Long>> lockCache = new WeakHashMap<>();

public static Object getLock(Longi)
{
    Long monitor = null;
    synchronized(lockCache) {
        Reference<Long> old = lockCache.get(i);
        if (old != null)
            monitor = old.get();

        // if no monitor exists yet
        if (monitor == null) {
            /* clone i for avoiding strong references 
               to the map's key besides the Object returend 
               by this method.
            */ 
            monitor = new Long(i);
            lockCache.remove(monitor); //just to be sure
            lockCache.put(monitor, new WeakReference<>(monitor));
        }

    }

    return monitor;
}