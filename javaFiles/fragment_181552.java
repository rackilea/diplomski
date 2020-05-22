try {
    connection = DBUtil.getConnection();
    statement = connection.prepareStatement("SELECT id, foo, bar FROM table");
    resultSet = statement.executeQuery();

   //Do what you need to do. 

} finally {
    if (resultSet != null) try { resultSet.close(); } catch (SQLException ignore) {}
    if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
    if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
}