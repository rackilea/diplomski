public class Stuff {
    public final ReentrantLock resourceLock = new ReentrantLock();

    public void doStuff() {

        /*Once locked by one thread other threads would be waiting on this line in WAIT state
         * There's no need to check if it's already locked or not, it's done by Java, if it's locked then Thread goes in WAIT state
         * It's not busy waiting, thread wakes up only when notified by Java.
         */
        resourceLock.lock();
        try {
            /* <Critical Section> */
            //Now since resource is locked, it can be exclusively used by this thread

            /* </Critical Section> */
        } finally {
            //Once unlocked other threads would compete to acquire lock on: resourceLock.lock();
            resourceLock.unlock();
        }
    }
}

public class Example {
    public HashMap<String, Stuff> resources;

    /**
     * This is a utility method to just check if the resource is locked by current Thread, it performs no role in locking resource.
     */
    public boolean isOwned(String resource) {
        return ((resources.get(resource).lock.isHeldByCurrentThread() == false) && (resources.get(resource).lock.isLocked()))
    }

    public boolean isNotOwned(String resource) {
        return !isOwned();
    }

    public void operation(String resource) {
        Stuff stuff = resources.get(resource);
        stuff.doStuff();
    }
}