public abstract class AEvent<T> {

    protected final T value;
    protected final Object source;

    public AEvent(Object source, T value) {
        this.value = value;
        this.source = source;
    }

    public Object getSource() {
        return source;
    }

    public T getValue() {
        return value;
    }
}