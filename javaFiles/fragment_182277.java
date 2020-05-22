// in the controller where this stuff is needed
private Map<String, Date> editLocks = new HashMap<>();
private Object concurrencyLock = new Object();


// function for acquiring a lock
private boolean getLock(String id) {
    synchronized(concurrencyLock) {
        Date lastLock = editLocks.get(id);
        if (lastLock == null || longAgoEnough(lastLock)) {
            // add a new lock to the map with the time of now
            editLocks.put(id, now());
            return true; // a lock was available
        }
    }
    // we get here because there's a valid lock
    return false;
}

private void releaseLock(String id) {
    synchronized(concurrencyLock) {
        editLocks.remove(id);
    }
}