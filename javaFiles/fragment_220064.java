ScheduledFuture<?> future = Mockito.mock(ScheduledFuture.class);
    Mockito.doReturn(future).when(executor).schedule(
        Mockito.any(Runnable.class),
        Mockito.anyLong(),
        Mockito.any(TimeUnit.class)
    );