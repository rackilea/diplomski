Iterator<? extends Number> iterator = null;
Iterable<? extends Number> iterable = toIterable(iterator);

public static <T> Iterable<T> toIterable(Iterator<T> it) {
    return () -> it;
}