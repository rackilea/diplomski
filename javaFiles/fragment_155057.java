public final class IteratorWrap<T>
    implements Iterable<T>
{
    private final Iterator<T> iterator;

    public static <X> IteratorWrap<X> wrap(final Iterator<X> iterator)
    {
        return new IteratorWrap<>(iterator);
    }

    private IteratorWrap(final Iterator<T> iterator)
    {
        this.iterator = Objects.requireNonNull(iterator);
    }

    @Override
    public Iterator<T> iterator()
    {
        return iterator;
    }
}