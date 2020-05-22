private static final Optional<?> EMPTY = new Optional<>(); //instantiate value when program starts

public static<T> Optional<T> empty() {
    @SuppressWarnings("unchecked")
    Optional<T> t = (Optional<T>) EMPTY; //return stored value when requested
    return t;
}