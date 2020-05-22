Map<Integer, String> dummy = new HashMap<Integer, String>();
    map.put(1, "a");
    map.put(2, "b");
    map.put(3, "c");
    map.put(4, "d");
    dummy.putAll(map);
    for (Iterator<Integer> keys = dummy.keySet().iterator(); keys.hasNext();) {
        Integer key = keys.next();
        String val = map.get(key);
        map.remove(key);
    }
    System.out.println(map);