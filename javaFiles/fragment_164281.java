public interface RootDAO<T> extends Serializable {

    public List<T> loadAll();

    public T save(T entity);

    public void delete(T entity);

    public void markAsDeleted(T entity);

    public T get(Serializable id);

    public T load(Serializable id);

    public void saveOrUpdate(T entity);

    public void deleteAll(Collection<T> entities);

    public void saveOrUpdateAll(Collection<T> entities);

    public List<T> find(String hql);

    public void update(T entity);

    public T getByExampleUnique(T entity);

    public List<T> getByExampleList(T entity);

    public List<T> listAll();

    public Object execute(HibernateCallback action);

    public List<T> findByNamedParam(String queryString, String paramName,Object value);

    public List<T> findByNamedParam(String queryString, String[] paramNames,Object[] values);
    .
    .
    .
    .

}