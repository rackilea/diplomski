public interface DAO<T> {

  void createTable();

  void insert(T t);

  T select(int id);

  void delete(int id);

  void update(T t, int id);
}