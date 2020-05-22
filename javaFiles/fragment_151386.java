public class SimpleArray<T> {

    private Object[] data;

    public SimpleArray(int size) {
        this.data = new Object[size];

    }

    @SuppressWarnings("unchecked")
    public T get(int i) {
        return (T)data[i];
    }
}