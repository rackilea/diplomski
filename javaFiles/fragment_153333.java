public class DB_Connect {
    protected static Connection conn;

    public DB_Connect() {
        if (conn == null) {
            try{
                String host = "jdbc:oracle:thin:@//...";
                String uName = "test";
                String uPass = "test";
                conn = DriverManager.getConnection(host,uName,uPass);
            }
            catch ( SQLException err ) {
                System.out.println(err.getMessage() );
            }
        }
    }
}

public class DB_Queries extends DB_Connect{
   private String sql = "SELECT * FROM table";

   public void get_Data(){
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            String smth_name = rs.getString("column_NAME");

            String p = "output: " + smth_name;
            System.out.println(p);
        }
        catch ( SQLException err ) {
            System.out.println(err.getMessage() );
        }
    }
}