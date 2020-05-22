when(db.persist(any(Foo.class))).thenAnswer(new Answer<Foo>() {
    @Override
    public Foo answer(InvocationOnMock invocation) throws Throwable {
        Foo foo  = (Foo) invocation.getArguments()[0];
        foo.setId(100);
        return foo;
    }
});