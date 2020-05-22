private ExecutorService executorService = Executors.newCachedThreadPool();

public Future<SomeObject> yourMethodName(String anyArguments) {
    return executorService.submit(
        new Callable<SomeObject>() {
            public SomeObject call() {
                SomeObject obj = new SomeObject();
                /* Your Code Here*/;
                return obj;
            }
        }
    );
}