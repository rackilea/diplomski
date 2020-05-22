package persistence;

public interface GenericDao<T, K extends Serializable>
{
    T find(K id);
    K save(T value);
    void update(T value);
    void delete(T value);
}