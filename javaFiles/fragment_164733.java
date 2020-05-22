package persistence;

public class PersonDaoImpl implements PersonDao {
    private Connection connection;

    public PersonDaoImpl(Connection connection) {
        this.connection = connection;
    }

    // Implement all the JDBC methods here.
}