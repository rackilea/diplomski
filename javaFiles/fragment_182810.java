PoolingHttpClientConnectionManager connectionManager = 
        new PoolingHttpClientConnectionManager();
connectionManager.setMaxTotal(100);
connectionManager.setDefaultMaxPerRoute(5);

ClientConfig clientConfig = new ClientConfig();
clientConfig.property(ApacheClientProperties.CONNECTION_MANAGER, connectionManager);
clientConfig.connectorProvider(new ApacheConnectorProvider());

Client client = ClientBuilder.newClient(clientConfig);