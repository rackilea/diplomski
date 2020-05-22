doAnswer(new Answer() {
    @Override
    public Object answer(InvocationOnMock invocation) throws Throwable {
        Callback callback= invocation.getArguments()[0];
        callback.onFail();
        return null;
    }
}).
doAnswer(new Answer() {
    @Override
    public Object answer(InvocationOnMock invocation) throws Throwable {
        Callback callback= invocation.getArguments()[0];
        callback.onSuccess();
        return null;
    }
}).
doAnswer(new Answer() {
    @Override
    public Object answer(InvocationOnMock invocation) throws Throwable {
        Callback callback= invocation.getArguments()[0];
        callback.onFail();
        return null;
    }
}).when(mockWorker).doWork(any(Callback.class));