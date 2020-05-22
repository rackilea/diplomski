public class CacheHelper
{
    private static HashMap foos, bars;
    private static java.util.concurrent.locks.ReadWriteLock lock = new java.util.concurrent.locks.ReentrantReadWriteLock();

    public static Foo getFoo(int fooId)
    {
        lock.readLock().lock();
        try {
            /* etc etc */
        } finally {
            lock.readLock().unlock();
        }
    }
    public static Bar getBar(int barId)
    {
        lock.readLock().lock();
        try {
            /* etc etc */
        } finally {
            lock.readLock().unlock();
        }
    }

    public static void reloadAllCaches()
    {
        lock.writeLock().lock();
        try {
            //This is where I need it to lock access to all the other static methods
        } finally {
            lock.writeLock().unlock();
        }
    }
}