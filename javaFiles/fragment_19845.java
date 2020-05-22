@Mock
private ResultSet resultSet;

...

when(statement.executeQuery(sql)).thenReturn(resultSet);
when(resultSet.getString(1)).thenReturn("X");

... call the class under the test...

// Add verification that "next" was called before "getString"...
// (not 100% necessary, but makes it a more thorough test)
InOrder order = inOrder(resultSet);
order.verify(resultSet).next();
order.verify(resultSet).getString(1);