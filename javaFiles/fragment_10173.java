Future<MyTask>future = taskExecutor.submit(myTask)
try {
    future.get(5,TimeUnit.Seconds);
    ...
    }
    catch (Exception e)
    {
        future.cancel(true); // attempt to interupt the thread
        throw new Exception();
    }