HttpClientConnectionManager connManager = PoolingHttpClientConnectionManager();

ClientConfig clientConfig = new ClientConfig();
clientConfig.connectorProvider(new ApacheConnectorProvider());
clientConfig.property(ApacheClientProperties.CONNECTION_MANAGER, connManager);

Client client = ClientBuilder.newClient(clientConfig);