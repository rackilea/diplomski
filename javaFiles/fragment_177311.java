public class Service<T> {
    public void add(final T entity);
    public void add(final T entity, final int index);
    public T lookUp(final T entity);
    public T get(final int index);
    public void remove(final T entity);
    public List<T> getAll();
}