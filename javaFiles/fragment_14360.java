//initialize connection...
String deleteString = "DELETE FROM fish.store WHERE first_name = ? AND last_name = ?";
PreparedStatement deleteStmt = null;
try {
    //...
    deleteStmt =  connection.prepareStatement(deleteString);
    deleteStmt.setString(1, "Clint");
    deleteStmt.setString(2, "Eastwood");
    deleteStmt.executeUpdate();
    connection.commit();
} catch...
//close connection