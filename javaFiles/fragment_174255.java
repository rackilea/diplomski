public void add(Integer key, String value) {
    LinkedList<String> list = cache.get(key);
    synchronized (list) {
        list.add(value);
    }
}