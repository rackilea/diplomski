class Test {
    final Map<Integer, AtomicInteger> map = new ConcurrentHashMap<>();

    public void add(int key, int value) {
        get(key).addAndGet(value);
    }

    private AtomicInteger get(int key) {
        AtomicInteger current = map.get(key);

        if (current == null) {
            AtomicInteger ai = new AtomicInteger();

            current = map.putIfAbsent(key, ai);

            if (current == null) {
                current = ai;
            }
        }

        return current;
    }

    public Object getResult() {
        return map.toString();
    }
}