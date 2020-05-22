private <T> T executeQuery(QHandler<T> handler) throws ContentManagerException {
    try (Connection connection = mDataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery(handler.getQuery())
    ) {
        return handler.handleResultSet(results);
    } catch (SQLTimeoutException e) {
        throw new ContentManagerException("Query took to long or connection timed out", e);
    } catch (SQLException e) {
        throw new ContentManagerException("Query or parsing its results failed", e);
    }
}