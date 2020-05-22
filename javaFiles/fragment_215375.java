private static final Set<Integer> LOCKER = Collections.newSetFromMap(
    new ConcurrentHashMap<Integer, Boolean>());

private static boolean tryLock(Integer key) {
    return LOCKER.add(key);
}

private static void releaseLock(Integer key) {
    LOCKER.remove(key);
}