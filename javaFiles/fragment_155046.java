public class Property<T> {

    private T value = null;

    public T get() {
        if (value == null)
            throw new UninitializedPropertyAccessException("Property has not been initialized");
        return value;
    }

    public void set(T value) {
        if (value == null)
            throw new IllegalArgumentException("Value can't be null");
        this.value = value;
    }

}