package persistence;

public interface PersonDao {
    List<Person> find(String lastName, String firstName);
    List<Person> find();
    void save(Person p);
    void update(Person p);
    void delete(Person p);
}