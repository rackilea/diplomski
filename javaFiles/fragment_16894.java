String s1 = "SET @count = 0";
String s2 = ...

try {
// query to reset menu_id manly after delete row
     connection = database.getConnection();
     Statement statement = connection.createStatement();
     statement.addBatch(s1);
     statement.addBatch(s2);    
     statement.addBatch(s2);   
     s.executeBatch();
     connection.commit();
} catch (SQLException e) {
    connection.rollback();
    throw e;
} finally {
    close(statement);
    close(connection);
}