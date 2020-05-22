public class IteratorWrapper<E> implements Iterable<E> {
    private Iterator<E> iterator;

    public IteratorWrapper(Iterator<E> iterator) {
        this.iterator = iterator;
    }

    public Iterator<E> iterator() {
        return iterator;
    }

    // Static import the following method for less typing at the
    // call sites.
    public static <E> IteratorWrapper<E> wrapIter(Iterator<E> iterator) {
        return new IteratorWrapper<E>(iterator);
    }
}