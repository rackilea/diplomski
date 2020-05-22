import java.sql.*;

public class Commoditywise {
    public static void main(String args[]) {
        String s = null;
        String id = "paddy";
        String driverName = "com.mysql.jdbc.Driver";
        String connectionUrl = "jdbc:mysql://localhost:3306/";
        String dbName = "mandi";
        String userId = "root";
        String password = "";
        String market = null;
        String rate = null;
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(connectionUrl + dbName,
                    userId, password);
            statement = connection.createStatement();
            String sql = "select ch.mandihindi,cw.price from Commoditywise cw inner join mandihindi ch on ch.mandieng=cw.mandi where cw.commodity=  '"
                    + id + "'";

            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                market = resultSet.getString("mandihindi");
                rate = resultSet.getString("price");
                s += market.concat("~").concat(rate).concat("|");
            }
            s = s.replaceAll(" ", "").substring(0, s.length() - 1);
            System.out.println(s);
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}