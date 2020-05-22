SslContextFactory theSSLFactory = new SslContextFactory();
theSSLFactory.setKeyStorePath("key");
theSSLFactory.setKeyManagerPassword("OBF:password");
theSSLFactory.setKeyStorePassword("OBF:password");
theSSLFactory.setTrustStore("trust");
theSSLFactory.setTrustStorePassword("OBF:password");

SslSocketConnector theSSLConnector = new SslSocketConnector(theSSLFactory);
theSSLConnector.setPort(theHTTPSPort);