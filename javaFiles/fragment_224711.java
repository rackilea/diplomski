Map<Integer, String> map = new ConcurrentHashMap<Integer, String>();
    map.put(1, "a");
    map.put(2, "b");
    map.put(3, "c");
    map.put(4, "d");
    for (Iterator<Integer> keys = map.keySet().iterator(); keys.hasNext();) {
        Integer key = keys.next();
        String val = map.get(key);
        map.remove(key);
    }