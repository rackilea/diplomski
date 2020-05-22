doAnswer(new Answer() {
    public Object answer(InvocationOnMock invocation) {
        Object[] args = invocation.getArguments();
        args[0] // that's the argument I want to modify
        return null;
    }})
 .when(parameterProvider).provideParameter(anyMap());