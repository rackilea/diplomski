@ClientAsyncExecutor
static class MyExecutorServiceProvider implements ExecutorServiceProvider {

    @Override
    public ExecutorService getExecutorService() {
        System.out.println("Calling getExecutorService()");
        return Executors.newFixedThreadPool(10);
    }

    @Override
    public void dispose(ExecutorService executorService) {
        executorService.shutdown();
    }
}

Client client = ClientBuilder.newClient()
client.register(new MyExecutorServiceProvider());

Future<Response> res = client.target("test").async().get()