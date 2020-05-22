public interface Repository<T, K extends Serializable> {
    List<T> find();
    T find(K id);
    K save(T value);
    void update(T value);
    void delete(T value);    
}