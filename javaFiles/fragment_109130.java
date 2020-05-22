public class SQL{

    protected Connection conn = null;
    protected String dbName = "mydatabase.db";

    public void connect(){
        if(conn != null){
            return;
        }
        try{
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbName);
        }catch(ClassNotFoundException | SQLException e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public boolean tableExists(String tableName){
        connect();
        try{
            DatabaseMetaData md = conn.getMetaData();
            ResultSet rs = md.getTables(null, null, tableName, null);
            rs.last();
            return rs.getRow() > 0;
        }catch(SQLException ex){
            Logger.getLogger(SQLite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}