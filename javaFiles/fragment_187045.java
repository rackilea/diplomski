public class Cast<T> implements Function<Object, T> {
    private Class<T> type;
    public Cast(Class<T> type) {
        this.type = type;
    }

    public T apply(Object in) {
        return type.cast(in);
    }
}