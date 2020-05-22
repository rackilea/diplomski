doAnswer(new Answer<Void>() {
    @Override
    public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
        return null;
    }
}).when(obj).myMethod(any(String.class));