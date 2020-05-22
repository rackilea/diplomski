public class MyDao {

    private InitialContext context;
    private DataSource datasource;

    public MyDao() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
            context = new InitialContext();
            datasource = (DataSource) context.lookup("datasource name");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
 public MyBean getMyBean() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet res = null;

        String sql = "some query";
        try {
            connection = datasource.getConnection();//pool connection
            statement = connection.prepareStatement(sql);
            res = statement.executeQuery();
            while (res.next()) {
               //return true

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

     finally {
            if (rs!= null) try { rs.close(); } catch (SQLException logOrIgnore) {}//result set if any
            if (stm!= null) try { stm.close(); } catch (SQLException logOrIgnore) {}//clase statement if any
            if (connection != null) try { connection.close(); } catch (SQLException logOrIgnore) {}//close connection
            }
            }


}//close MyDao