public String fetchSomeDataInTransactionStyle() {
    try (Connection conn = getConnection()) { // This line, with this syntax, will ensure that it is automatically closed in an invisible "finally" block
        conn.setAutocommit(false);
        addSomethingToTransaction(conn);
        addSomethingMore(conn);
        conn.commit();
    } catch (SQLException e) {
        // No need to do clean up here, log the exception or do whatever you want.
    }
}