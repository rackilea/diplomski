final PooledConnectionHandler conHandler = context.mock(PooledConnectionHandler.class);
final Statement statement = context.mock(Statement.class);
final Connection connectionProxy = context.mock(Connection.class);
final StatementHandler handler = new StatementHandler(conHandler, statement);

context.checking(new Expectations() {
    {
        oneOf(conHandler).getProxy(); will(returnValue(connectionProxy));
    }
});