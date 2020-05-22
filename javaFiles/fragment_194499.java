ExecutorService service = Executors.newCachedThreadPool();

Callable<String> task = new Callable<String>() {
    public String call() throws Exception {
        return "hello world";
    }
};

Future<String> future = service.submit(task);