ResultSet resultSet = Mockito.mock(ResultSet.class);
Mockito.when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false);
Mockito.when(resultSet.getString(1)).thenReturn("table_r3").thenReturn("table_r1").thenReturn("table_r2");

Statement statement = Mockito.mock(Statement.class);
Mockito.when(statement.executeQuery("SELECT name FROM tables")).thenReturn(resultSet);

Connection jdbcConnection = Mockito.mock(Connection.class);
Mockito.when(jdbcConnection.createStatement()).thenReturn(statement);