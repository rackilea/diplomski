public class MysqlConnection {
    public Connection con;
    /*public ResultSet rs;
    public Statement st;
    public PreparedStatement ps;
    public DataSource ds=null;*/
    public String User;
    public String Uid;
    public String Pwd;

    public String StrUrl="jdbc:mysql://localhost:50781/jayshreesteels?zeroDateTimeBehavior=CONVERT_TO_NULL";
    public String StrUid="root";
    public String StrPwd= "root";
    public static String StrUser;

    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        String Url="jdbc:mysql://localhost:50781/jayshreesteels?zeroDateTimeBehavior=CONVERT_TO_NULL";
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    public MysqlConnection() throws SQLException {
        this.con = DriverManager.getConnection(StrUrl, "root", "root");
    }
}