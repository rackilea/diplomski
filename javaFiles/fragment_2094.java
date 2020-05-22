private final ConcurrentHashMap<String, Object> lockMap = new ConcurrentHashMap<>();
public void method(String key, ...) {
    synchronized(getLock(key)) {
        ....
    }
}
protected Object getLock(String key) {
    Object newLock = new Object(), lock = lockMap.putIfAbsent(key, newLock);
    return lock == null? newLock: lock;
}