java.sql.Connection c = YOUR_CONNECTION;
Liquibase liquibase = null;
try {
    Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(c))
    liquibase = new Liquibase(YOUR_CHANGELOG, new FileSystemResourceAccessor(), database);
    liquibase.update();
} catch (SQLException e) {
    throw new DatabaseException(e);
} finally {
    if (c != null) {
        try {
            c.rollback();
            c.close();
        } catch (SQLException e) {
            //nothing to do
        }
    }
}