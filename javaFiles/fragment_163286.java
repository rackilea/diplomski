public class EntityUtils
{
    private static final ReadWriteLock RW_LOCK = new ReentrantReadWriteLock();
    private static final Map<String, Map<String, String>> searchMap = new HashMap<>();

    private static Map<String, String> getSearchablePathMap(String key)
    {
        RW_LOCK.readLock().lock();
        try
        {
            Map<String, String> pathMap = searchMap.get(key);
            if(pathMap != null) return pathMap;
        }
        finally
        {
            RW_LOCK.readLock().unlock();
        }

        RW_LOCK.writeLock().lock();
        try
        {
            //first check to see if a previous holder of write lock built map for us
            Map<String, String> pathMap = searchMap.get(key);
            if(pathMap != null) return pathMap;

            pathMap = new HashMap<>();
            pathMap.put(..., ...);
            ...
            // heavy map population operations
            ...

            pathMap = Collections.unmodifiableMap(pathMap);

            searchMap.put(key, pathMap);
        }
        finally
        {
            RW_LOCK.writeLock().unlock();
        }

        return pathMap;
    }
}