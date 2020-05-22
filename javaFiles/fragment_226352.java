public String fetchSomeData() {
    try (Connection conn = getConnection()) { // This line, with this syntax, will ensure that it is automatically closed in an invisible "finally" block
        // Do what you need to do with the data, return it or something else
    } catch (SQLException e) {
        // No need to do clean up here, log the exception or do whatever you want.
    }
}