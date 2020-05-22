public class ConnectionUcanaccess {

    static
    {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            System.out.println("driver loaded");
        } catch (ClassNotFoundException e) {
            System.out.println("the class driver can't be loaded");
        }
    }

    static Connection getConnection() throws SQLException {
     return DriverManager.getConnection("jdbc:ucanaccess:///Users/shared/Desktop/database.accdb");
    }

    public static void main(String[] args){

        try {
            Connection con = ConnectionUcanaccess.getConnection();
            System.out.println("Connected: " + !con.isClosed());

        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
}