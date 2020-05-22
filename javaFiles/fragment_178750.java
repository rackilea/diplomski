@Before
public void onSetUpInTransaction() throws Exception {
    Connection conn = dataSource.getConnection();
    try {
        IDatabaseConnection connection = new DatabaseConnection(conn);
        DatabaseConfig config = connection.getConfig();
        config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY,
                new HsqldbDataTypeFactory());
                    DataFileLoader loader = new FlatXmlDataFileLoader();
            IDataSet ds = loader.load(TEST_DATA_FILE_CLUB);
                    DatabaseOperation.CLEAN_INSERT.execute(connection,ds);
            } finally {
        DataSourceUtils.releaseConnection(conn, dataSource);
    }
}