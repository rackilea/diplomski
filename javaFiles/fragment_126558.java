doAnswer(
    (InvocationOnMock invocation) -> {
        ((Runnable) invocation.getArguments()[0]).run();
        return null;
    }
).when(serviceAExecutorService).execute(any(Runnable.class));