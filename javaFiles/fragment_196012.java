Map<Key, Integer> map = new TreeMap<>();

if(map.containsKey(key)) {
    map.put(key, map.get(key) + 1);
} else {
    map.put(key, 1);
}