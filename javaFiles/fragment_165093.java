ConcurrentMap<String, String> map = new ConcurrentHashMap<String, String>(); //
AtomicReference<Map<String, String>> frozenCopy = new AtomicReference<Map<String, String>>(map); 

public void sortOperation() {
    sortUsingFrozenCopy();
}

public void updateOperation() {
    synchronized (map) { // Exclusive access to the map instance
        updateMap();
        Map<String, String> newCopy = new HashMap<String, String>();
        newCopy.putAll(map); // You build the copy. This is safe thanks to the exclusive access.
        frozenCopy.set(newCopy); // And you update the reference to the copy
    }
}