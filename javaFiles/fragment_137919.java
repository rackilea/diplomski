public class DirtyQuickTest {
    private static final String url = "jdbc:mysql://localhost:7841/test";
    private static final String user = "lmendozaj";
    private static final String password = "s3cr3t"; //I won't show you my password
    public static void main(String[] args) throws Exception {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            //commented since doesn't exists in Java 6
            //System.out.println(con.getSchema());
            System.out.println(con.getCatalog());
        } finally {
            con.close();
        }
    }
}