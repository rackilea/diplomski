package persistence;

public interface GenericDao<K, V> {
    V find(K id);
    List<V> find();
    K save(V value);
    void update(V value);
    void delete(V value);
}