public void add(String x,String y) {
    Set<String> set = words.get(x);
    if (set == null) {
        words.put(x, set = new HashSet<String>());
    } 
    set.add(y);
}