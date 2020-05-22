public interface GenericCrudService {
    public <T> T create(T t);
    public <T> T find(Class<T> type, Object id);
    public <T> void delete(T t);
    public <T> T update(T t);
    public List findWithNamedQuery(String queryName);
    public List findWithNamedQuery(String queryName, int resultLimit);
    public List findWithNamedQuery(String namedQueryName, 
                                   Map<String, Object> parameters);
    public List findWithNamedQuery(String namedQueryName, 
                                   Map<String, Object> parameters,
                                   int resultLimit);
    public <T> List<T> findWithNativeQuery(String sql, Class<T> type);
}