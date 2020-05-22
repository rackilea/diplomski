synchronized (map) {
    if (map.containsKey(key)) {
        B oldB = map.get(key);
        // work with oldB
    } else {
        map.put(key, b);
    }
}