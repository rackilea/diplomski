import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    private static PreparedStatement preparedStmt = null;
    private static Connection connection = null;

    public static void main(String[] args) {
        String gOccupied = "Occupied";
        String occupantname = txtFirstNames.getText();
        String query = "UPDATE rooms SET occupantname = ? , status= ? WHERE roomnumber = ?";
        try {
            executeSQlquery(query, occupantname, gOccupied, "Updated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void executeSQlquery(String query, String occupantname, String gOccupied, String status) throws SQLException {
        try {
            // create a java mysql database connection
            String myDriver = "org.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost/test";
            Class.forName(myDriver);
            connection = DriverManager.getConnection(myUrl, "username", "password");
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, occupantname);
            preparedStmt.setString(2, gOccupied);
            preparedStmt.setInt(3, 101);

            // execute the java preparedstatement
            preparedStmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            if (preparedStmt != null) {
                connection.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

}