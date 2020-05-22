public class UserDao {


    private final String configFilename;

    public UserDao(String filename) {
        this.configFilename = filename;
    }

    public Connection getConnection() {

        input = cl.getResourceAsStream(this.configFilename);
    ...
    }

}