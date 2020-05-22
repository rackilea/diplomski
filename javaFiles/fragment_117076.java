MyFactory myFactory = mock(MyFactory.class);

Answer<C> answer = new Answer<C>() {
    public C answer(InvocationOnMock invocation) throws Throwable {
        A a = invocation.getArgument(0, A.class);
        B b = invocation.getArgument(1, B.class);
        return new C(a, b);
    }
};

// either of these ...
when(myFactory.create(Mockito.any(A.class), Mockito.any(B.class))).thenAnswer(answer);

doAnswer(answer).when(myFactory.create(Mockito.any(A.class), Mockito.any(B.class)));