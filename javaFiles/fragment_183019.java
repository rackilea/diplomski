final MinimalHttpAsyncClient client = HttpAsyncClients.createMinimal(
       HttpVersionPolicy.FORCE_HTTP_2, 
       H2Config.DEFAULT, 
       null, 
       ioReactorConfig, 
       connectionManager);