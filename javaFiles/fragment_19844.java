@Mock
private Statement statement;

...

when(connectionMock.createStatement()).thenReturn(statement);
when(statement.executeQuery(sql)).thenAnswer(...);