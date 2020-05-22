public class BaseDAO<T> {
    private Class<T> clazz;

    public BaseDAO(Class<T> clazz) {
        super();
        this.clazz = clazz;
    }

    public T find(Long id) { ... }

    public List<T> findAll() { ... }

    public T create(T entity) { ... }

    public T update(T entity) { ... }

    public void delete(T entity) { ... }
}