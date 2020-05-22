public final class TypedInjectable<T> implements Injectable<T> {

    private final T value;
    private final Class<T> type;

    private TypedInjectable(final T value, final Class<T> type) {
        this.value = value;
        this.type = type;
    }

    public static <T> TypedInjectable<T> injectable(final T value, final Class<T> type) {
        return new TypedInjectable<>(value, type);
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public Class<T> getType() {
        return type;
    }
}