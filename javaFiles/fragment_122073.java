public interface Iterator<E> {
    ...
    default void remove() {
        throw new UnsupportedOperationException("remove");
    }
    ...
}