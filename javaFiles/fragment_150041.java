Connection conn = null;
try {
    conn = // get connection;

    // do database operations

} catch (final SQLException e) {
    throw new DAOException(e);
} finally {
    if (conn != null) {
        try {
            conn.close();
        } catch (final SQLException ex) {
            LOG.warning("message warning to log");
        }
    }
}