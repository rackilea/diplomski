public void insertDateValue(DateTime value) throws SQLException {

    String insertString = "INSERT INTO tableName(datecolumn) VALUES(?)";

    PreparedStatement insert = null;

    try {
        insert = connection.prepareStatement(insertString);

        // Important part is right here:
        insert.setDate(1, new Date(value.getMillis()));
        // Oh, and the new object should be java.sql.Date


        insert.executeUpdate();
        connection.commit();
    } catch (SQLException e ) {
        if (con != null) {
            try {
                connection.rollback();
            } catch(SQLException excep) {
                // Should maybe do something here
            }
        }
    } finally {
        if (insert != null) {
            insert.close();
        }
    }
}