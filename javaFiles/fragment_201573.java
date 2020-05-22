public static <T, R> Function<? super T, Stream<FlatEntry<T, R>>> flatEntryMapper(Function<? super T, ? extends Stream<? extends R>> mapper)
{
    return element -> mapper.apply(element).map(value -> new FlatEntry<>(element, value));
}

public static class FlatEntry<E, V>
{
    /** The original stream element */
    public final E element;

    /** The flattened value */
    public final V value;

    private FlatEntry (E element, V value)
    {
        this.element = element;
        this.value = value;
    }
}