@Test
public void test() throws Exception {
    PreparedStatementResultSetHandler statementHandler = getJDBCMockObjectFactory()
            .getMockConnection().getPreparedStatementResultSetHandler();
    MockResultSet resultMock = statementHandler.createResultSet();
    resultMock.addColumn("ID", new Object[]{"1"});
    resultMock.addColumn("USERNAME", new Object[]{"foobar"});
    statementHandler.prepareGlobalResultSet(resultMock);

    Connection con = DriverManager.getConnection( "a", "b", "c");
    PreparedStatement stmtObjects = con.prepareStatement(
            "SELECT * FROM USER");
    ResultSet rs = stmtObjects.executeQuery();
    assertTrue(rs.next());
    //System.out.println(rs); 
    //System.out.println(getExecutedSQLStatements()); 
    verifySQLStatementExecuted("SELECT * FROM USER");
}