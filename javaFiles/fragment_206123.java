public class Wrapper<T> {
    private final T item;
    private final int id;

    ...

    public int getId() { return id }

    public T getItem() { return item; }

}