/**
 * Makes sure the iterator is never used again - even though it is wrapped in an Iterable.
 *
 * @param <T>
 */
public static class SingleUseIterable<T> implements Iterable<T> {

    protected boolean used = false;
    protected final Iterator<T> it;

    public SingleUseIterable(Iterator<T> it) {
        this.it = it;
    }

    public SingleUseIterable(Iterable<T> it) {
        this(it.iterator());
    }

    @Override
    public Iterator<T> iterator() {
        if (used) {
            throw new IllegalStateException("SingleUseIterable already invoked");
        }
        used = true;
        // Only let them have it once.
        return it;
    }

}

/**
 * Adapts an {@link Iterator} to an {@link Iterable} for use in enhanced for loops.
 *
 * If {@link Iterable#iterator()} is invoked more than once, an {@link IllegalStateException} is thrown.
 *
 * @param <T>
 * @param i
 * @return
 */
public static <T> Iterable<T> in(final Iterator<T> i) {
    return new SingleUseIterable<>(i);
}