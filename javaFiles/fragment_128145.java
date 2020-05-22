public void testDoFoo() {
    Mockery mockery = new Mockery();
    Logger mockLogger = mockery.mock(Logger.class);

    Foo foo = new Foo();

    foo.setLogger(mockLogger);

    mockery.checking(new Expectations() {
        {
            never(mockLogger).debug(with(any(String.class));
        }
    };

    ...
    //do the actual test.

    //assert the mock type has never been called.
    mockery.assertIsSatisfied();
}