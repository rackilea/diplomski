public class DB_Connect {
    private Connection conn;

    public DB_Connect() {
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

    public getConnection() {
        return conn;
    }
}

public class DB_Queries {
   private String sql = "SELECT * FROM table";
   private DB_connect connect;

   public DB_Queries(DB_Connect connect) {
       this.connect= connect;
   }

   public void get_Data(){
        try{
            Statement stmt = connect.getConnection().createStatement();
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