private Optional(T value) {
    this.value = Objects.requireNonNull(value); //this throws NullPointerException
}
public static <T> Optional<T> of(T value) {
        return new Optional<>(value);
}
public static <T> Optional<T> ofNullable(T value) {
        return value == null ? empty() : of(value);
}