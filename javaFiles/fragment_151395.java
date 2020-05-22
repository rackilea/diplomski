public class ConnectDB {
    private static ConnectDB instance = null;

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch (ClassNotFoundException e) {
            //TODO manage exception
            e.printStackTrace();
        }
    }

    public static ConnectDB getInstance(){
        if(null == instance) 
            instance = new ConnectDB();

        return instance;
    }

    public Connection getConnection() {
        Connection connection = null;

        try{
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","yy","yy");
        }catch(SQLException e){
            //TODO manage exception
            e.printStackTrace();
        }

        return connection;      
    }
}