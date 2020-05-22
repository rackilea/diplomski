ClientConfig clientConfig = new ClientConfig();
clientConfig.property(ApacheClientProperties.CONNECTION_MANAGER, new PoolingClientConnectionManager());
//config your ssl for apache connector
SslConfigurator sslConfig = SslConfigurator.newInstance();
clientConfig.property(ApacheClientProperties.SSL_CONFIG, sslConfig);

ApacheConnector connector = new ApacheConnector(clientConfig);  
clientConfig.connector(connector);  

Client client = ClientBuilder.newBuilder()
.withConfig(clientConfig)
.hostnameVerifier(getHostnameVerifier())
.build();