@Before
public void setUp() throws SQLException {
    when(mockConn.prepareStatement(anyString(), anyInt())).thenReturn(mockPreparedStmnt);
    doNothing().when(mockConn).commit();
    doNothing().when(mockPreparedStmnt).setString(anyInt(), anyString());
    when(mockPreparedStmnt.execute()).thenReturn(Boolean.TRUE);
    when(mockPreparedStmnt.getGeneratedKeys()).thenReturn(mockResultSet);
    when(mockResultSet.next()).thenReturn(Boolean.TRUE, Boolean.FALSE);

    underTest = new MyDao(){
        @Override
        public Connection getConnection() {
            return mockConn;
        }
    };
}