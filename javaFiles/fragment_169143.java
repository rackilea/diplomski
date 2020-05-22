public class CombinedIterable<T> implements Iterable<T> {

    public static <T> Iterable<T> concat(Iterable<? extends T>... iterables) {
        return new CombinedIterable<T>(iterables);
    }

    private final List<Iterable<? extends T>> iterables;

    private CombinedIterable(Iterable<? extends T>... iterables) {
        this.iterables = Arrays.asList(iterables);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private final Iterator<Iterable<? extends T>> pos = iterables.iterator();
            private Iterator<? extends T> iter = pos.next().iterator();

            @Override
            public boolean hasNext() {
                if (iter.hasNext()) {
                    return true;
                }
                if (pos.hasNext()) {
                    iter = pos.next().iterator();
                }
                return iter.hasNext();
            }

            @Override
            public T next() {
                return iter.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported.");
            }
        };
    }

}