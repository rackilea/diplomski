Connection c = null;
try {
    c = this.dataSource.getConnection();
    c.executeStatement("select * from dual");
} catch (SQLException e) {
    // handle...
} finally {
    closeConnection(c);
}