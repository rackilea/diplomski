public void addBatch() throws SQLException {
    if (this.batchPreparedStatements == null) {
        this.batchPreparedStatements = new ArrayList();
    }
    this.batchPreparedStatements.add(new MySQLPreparedStatement(
            this.connection, this.sql, this.dQuery,
            this.useFractionalSeconds));
}