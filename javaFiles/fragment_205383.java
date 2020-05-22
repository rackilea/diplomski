Connection connection = null;
PreparedStatement statement = null;
try {
    connection = dataSouce.getConnection();
    statement = connection.prepareStatement('some query');

    statement.executeUpdate();
} catch(SQLException e) {
    throw new SomeWrapperException(e);
} finally {
    try {
    //    if (statement != null) {
    //        statement.close();
    //    }
        if (connection != null) {
           connection.close();
        }
    } catch (SQLException e) {
        throw new SomeWrapperException(e);
    }
}