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