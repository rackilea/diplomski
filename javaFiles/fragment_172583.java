private final Set<Object> mySet = new HashSet<Object>();
private final ReadWriteLock lock = new ReentrantReadWriteLock();
public void methodThatRunsAndAllowsReadOnly() {
    lock.readLock().lock();
    try {
        // method body here
    }
    finally {
       lock.readLock().unlock();
    }
}

public void putInSet(Object o) {
    lock.writeLock().lock();
    try {
        mySet.add(o);
    }
    finally {
       lock.writeLock().unlock();
    }
 }