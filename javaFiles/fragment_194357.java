@Before
public void setUp() throws Exception
{
    logger.info("Performing the setup of test {}", testName.getMethodName());
    IDatabaseConnection connection = null;
    try
    {
        connection = getConnection();
        IDataSet dataSet = getDataSet();
        //The following line cleans up all DbUnit recognized tables and inserts and test data before every test.
        DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
    }
    finally
    {
        // Closes the connection as the persistence layer gets it's connection from elsewhere
        connection.close();
    }
}

private IDatabaseConnection getConnection() throws Exception
{
    @SuppressWarnings({ "rawtypes", "unused" })
    Class driverClass = Class.forName("org.apache.derby.jdbc.ClientDriver");
    Connection jdbcConnection = DriverManager.getConnection(jdbcURL, "XXX",
            "YYY");
    IDatabaseConnection databaseConnection = new DatabaseConnection(jdbcConnection);
    return databaseConnection;
}

private IDataSet getDataSet() throws Exception
{
    ClassLoader classLoader = this.getClass().getClassLoader();
    return new FlatXmlDataSetBuilder().build(classLoader.getResourceAsStream("database-test-setup.xml"));
}