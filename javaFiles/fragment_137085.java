public abstract class GenericDao<T> {
    private Class<T> clazz;

    public GenericDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T getById(Long key) {
        return getEntityManager().find(clazz, key);
    }
    protected abstract EntityManager getEntityManager();
}