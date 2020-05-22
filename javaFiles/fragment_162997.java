public <T> void add(List<T> list, int i, T obj) {
    while (list.size() < i) {
        list.add(null);
    }
    list.add(i, obj);
}