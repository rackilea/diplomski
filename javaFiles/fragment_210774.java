public class Array<T> {
    private final T[] arr;

    public Array(final int size, final Class<T> clazz) {
        this.arr = createArray(size, clazz);
    }

    private T[] createArray(final int size, final Class<T> clazz) {
        return (T[]) java.lang.reflect.Array.newInstance(clazz, size);
    }
}