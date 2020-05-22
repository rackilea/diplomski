session.doWork(new Work() {
    public void execute(Connection connection) throws SQLException {
        CallableStatement callable = connection.prepareCall("{? = call dbo.old_remaining(?)}");
        callable.registerOutParameter( 1, Types.FLOAT );
        callable.setString(2, "your string parameter");
        callable.execute();
        float functionResult = callable.getFloat(1);
    }
});