public Connection createMockConnection() {
    Connection mockConnection = mock(Connection.class);

    try {
        doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                mockData = (byte[]) invocation.getArguments()[0];
                return null;
            }
        }).when(mockConnection).write(any(byte[].class));

        when(mockConnection.read()).thenAnswer(new Answer<byte[]>() {
            @Override
            public byte[] answer(InvocationOnMock invocation) throws Throwable {
                return mockData;
            }
        });
    } catch (Exception e) {}

    return mockConnection;
}