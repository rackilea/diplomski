static class MyHttpServiceConfig {
    int workerNum = 10;
};

MyHttpServiceConfig config = new MyHttpServiceConfig();

CloseableHttpClient client = HttpClients.custom()
        .setMaxConnPerRoute(config.workerNum)
        .build();

ExecutorService executor = Executors.newFixedThreadPool(config.workerNum);

FutureRequestExecutionService executionService = new FutureRequestExecutionService(
         client, executor);