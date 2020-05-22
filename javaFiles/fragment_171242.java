public void add(String s) {
    if (map.containsKey(s)) {
        map.put(s, map.get(s) + 1);
    } else {
        map.put(s, 1);
    }
}