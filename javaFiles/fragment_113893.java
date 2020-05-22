public interface GenericDAO<T, ID extends Serializable> {


    T findById(ID id, LockModeType lock);

    void save(T entity);

    T update(T entity);

    List<T> findAll();
}