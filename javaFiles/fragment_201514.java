final A myMockInstance = createAMock();
new AbstractModule() {
  @Override protected void configure() {}

  @Provides
  A.AFactory createAFactory() {
    A.AFactory factory = mock(A.AFactory.class);
    when(factory.createA(anyString(), anyInt(), any(Dependency.class)))
        .thenReturn(myMockInstance);
    return factory;
  }
});