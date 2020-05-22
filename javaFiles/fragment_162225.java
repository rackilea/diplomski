@Override
    protected DatabaseOperation getSetUpOperation() throws Exception
    {
        dbConnection = DriverManager.getConnection("jdbc:hsqldb:mem:tests", "sa", "");
        createTables();
        return DatabaseOperation.REFRESH;
    }

    private void createTables() throws Exception {
        PreparedStatement statement = dbConnection
                .prepareStatement("CREATE TABLE digidauthsessions ( "
                        + "id INTEGER IDENTITY NOT NULL PRIMARY KEY,"
                        + "request_token VARCHAR(50) NOT NULL,"
                        + "response_token VARCHAR(50) NOT NULL,"
                        + "relatienr VARCHAR(50) NOT NULL,"
                        + "digidnameid VARCHAR(1000) NOT NULL" + ")");
        statement.execute();
        statement.close();
    }