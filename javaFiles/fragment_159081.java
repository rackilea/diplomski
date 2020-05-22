class ComparableFromComparator<T> implements Comparable<T> {

    private final Comparator<T> comparator;
    private final T instance;

    public ComparableFromComparator(Comparator<T> comparator, T instance) {
        this.comparator = comparator;
        this.instance = instance;
    }

    @Override
    public int compareTo(T o) {
        return comparator.compare(instance, o);
    }

    public T getInstance() {
        return instance;
    }
}