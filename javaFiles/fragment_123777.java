public interface Dao<T> {

    // you can customise these signatures by your needs
    // these are just my suggestions

    T get(long id);

    List<T> getAll();

    T add(T t);

    T update(T t);

    void delete(T t);
}

public class UserDao implements Dao<User> {

    public User get(long id) { ... }

    public List<User> getAll() { ... }

    public User add(User user) { ... }

    public User update(User user) { ... }

    public void delete(User user) { ... }
}