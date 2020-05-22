public class ArrayLinearList<T> implements LinearList<T>, Iterable<T> {

    private final T[] elements;

    public ArrayLinearList(final int length) {
        @SuppressWarnings("unchecked") // won't be exposed outside this class
        final T[] withNarrowedType = (T[])new Object[length];
        elements = withNarrowedType;
    }

    public final void set(final int index, final T element) {
        elements[index] = element;
    }
}