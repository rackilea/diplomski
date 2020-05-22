public class ToMock {

    private Connection connection;

    public ToMock(Connection connection){
        this.connection = connection;
    }

    private functionA(String name) {       
        // do something    

        return xyz;
    }
}  



public class ToMockFactory {

    public static ToMock toMock(){
        return new ToMock(functionB());
    }

    public static Connection functionB() {
        return functionC("localhost", 10000);    
    }

    public static Connection functionC(String hostName, int port) {
        //make a connection to db

        String connectionString =     String.format("jdbc:hive2://%s:%d/",emrHost, port);

        LOGGER.info("Connection string {}", connectionString);

        try {

            Class.forName("org.apache.hive.jdbc.HiveDriver");    
            Connection con = DriverManager.getConnection(connectionString,   "hadoop", "");

            LOGGER.info("Connected successfully");

            return con;    
        } catch (ClassNotFoundException e) {
            throw Throwables.propagate(e);
        }
    }
}