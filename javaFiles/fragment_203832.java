public class MyContainer<T> {
    private final Set<T> set = new HashSet<>();
    private final List<T> list = new ArrayList<>();

    public void add(T e) {
        if (set.add(e)) {
            list.add(e);
        }
    }

    public T getRandomElement() {
        return list.get(ThreadLocalRandom.current().nextInt(list.size()));
    }
    // other methods as needed ...
}