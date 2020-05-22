finally
{
    try {
        stmt.close();
    } catch (SQLException sqle) {
        // log the statement-close exception
    }

    try {
        dbConn.close();
    } catch (SQLException sqle) {
        // log the connection-close exception
    }
}