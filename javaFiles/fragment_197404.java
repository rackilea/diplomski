@Test
public void driverManagerIsCorrectlyCalledForPg() throws Exception {
    // Arrange
    mockStatic(DatabaseProperties.Pg.class);
    doReturn(pg).when(databaseProperties).getPg();
    doReturn("server").when(pg).getServer();
    doReturn(1338).when(pg).getPort();
    doReturn("database_name").when(pg).getDatabasename();
    doReturn("user").when(pg).getUser();
    doReturn("password").when(pg).getPassword();

    mockStatic(DriverManager.class);
    doNothing().when(databaseDriverLoader).loadAdsDriverClass();
    doNothing().when(databaseDriverLoader).loadPgDriverClass();

    when(DriverManager.getConnection(anyString())).thenReturn(expectedConnection);

    // Act
    connectionFactory.newConnection(ConnectionType.POSTGRESQL);

    // Assert
    verifyStatic();
    DriverManager.getConnection("jdbc:postgresql://server:1338/database_name?user=user&password=password");
}