import java.sql.*;

/**
 * You will need to do some work to get this class to work fully and this is obviously     basic but its to give you an idea.
 */
public class StaffDAO {

public boolean checkStaffExists(String staffName) {
    boolean staffExists = false;

    try {
        String query = "SELECT * FROM STAFF_TABLE WHERE STAFF_NAME = ?";
        PreparedStatement preparedStatement = getDBConnection().prepareStatement(query);

        // Load your variables into the string in order to be safe against injection attacks.
        preparedStatement.setString(1, staffName);
        ResultSet resultSet = preparedStatement.executeQuery();

        // If a record has been found the staff member is in the database. This obviously doesn't account for multiple staff members
        if(resultSet.next()) {
            staffExists = true;
        }
    } catch (SQLException e) {
        System.out.println("SQL Exception in getStaff: " + e.getMessage());
    }

    return staffExists;
}

// Method names should be camel cased
public void updateStaff(String staffName) throws Exception {

    try {
        String query = "YOUR QUERY";
        PreparedStatement preparedStatement = getDBConnection().prepareStatement(query);

        // Load your variables into the string in order to be safe against injection attacks.
        preparedStatement.setString(1, staffName);
        ResultSet resultSet = preparedStatement.executeQuery();

    } catch (SQLException e) {
        System.out.println("SQL Exception in getStaff: " + e.getMessage());
    }

}

public void insertStaff(String staffName) throws Exception {

    try {
        String query = "YOUR QUERY";
        PreparedStatement preparedStatement = getDBConnection().prepareStatement(query);

        // Load your variables into the string in order to be safe against injection attacks.
        preparedStatement.setString(1, staffName);
        ResultSet resultSet = preparedStatement.executeQuery();

    } catch (SQLException e) {
        System.out.println("SQL Exception in getStaff: " + e.getMessage());
    }

}


/**
 * You need to abstract the connection logic away so you avoid code reuse.
 *
 * @return
 */
private Connection getDBConnection() {
    Connection connection = null;

    try {
        Class.forName("com.mysql.jdbc.Driver");

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/default", "root", "1234567");
    } catch (ClassNotFoundException e) {
        System.out.println("Could not find class. DB Connection could not be created: " + e.getMessage());
    } catch (SQLException e) {
        System.out.println("SQL Exception. " + e.getMessage());
    }

    return connection;
   }
}