public void add(Object key, Object val) {
    List list = map.get(key);
    if (list == null) {
        list = new LinkedList();
        List temp = map.putIfAbsent(list);
        if (temp != null)
            list = temp;
    }
    list.add(val);
}