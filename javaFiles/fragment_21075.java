B bMock = createMock(B.class);
expectNew(B.class, "someargument").andReturn(bMock);
expect(bMock.getValue()).andReturn(something);

replay(bMock, B.class);
verify(bMock, B.class);