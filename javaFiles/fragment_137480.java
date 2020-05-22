public class Heap<T> { /* no need for items to extend Comparable anymore */
    private final Comparator<T> cmp;

    public Heap(Comparator<T> cmp) {
        this.cmp = cmp;
        ...
    }

    ...
}