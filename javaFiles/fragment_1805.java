class Test {
    final Map<Integer, Integer> map = new ConcurrentHashMap<>();

    public void add(int key, int value) {
        map.merge(key, value, Integer::sum);
    }

    public Object getResult() {
        return map.toString();
    }
}