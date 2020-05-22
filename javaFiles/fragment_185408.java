public class CreateConnection {

    private static final Logger LOGGER = Logger.getLogger(CreateConnection.class);

    private static Connection instance = null;
    static final String drivername = "org.apache.hive.jdbc.HiveDriver";

    public static Connection getInstance() {
        LOGGER.info("Connection Instance");
        if (instance == null) {
            instance = createConnection();
        }
        return instance;
    }

    private static Connection createConnection() {
        try {
            LOGGER.info("Creating the connection");

            Class.forName(drivername);
            return DriverManager.getConnection("jdbc:hive2://hddev-c01-edge-02:9083/");
        } catch (ClassNotFoundException e) {
            LOGGER.error("Error occurred to create connection",e);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }
}