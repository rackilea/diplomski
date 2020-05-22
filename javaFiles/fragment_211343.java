for (Entry<String, String> e1 : map2.entrySet()) {
    String s = e1.getValue();
    for (Entry<String, Integer> e2 : map1.entrySet()) {
        s = s.replace(e2.getKey(), e2.getValue().toString());
    }
    map2.put(e1.getKey(), s);
}