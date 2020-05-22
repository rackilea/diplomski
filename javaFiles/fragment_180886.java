Server server = new Server();

// === HTTP Configuration ===
HttpConfiguration http_config = new HttpConfiguration();
http_config.setSecureScheme("https");
http_config.setSecurePort(8443);
http_config.setOutputBufferSize(32768);
http_config.setRequestHeaderSize(8192);
http_config.setResponseHeaderSize(8192);
http_config.setSendServerVersion(true);
http_config.setSendDateHeader(false);

// === Add HTTP Connector ===
ServerConnector http = new ServerConnector(server,
    new HttpConnectionFactory(http_config));
http.setPort(8080);
http.setIdleTimeout(30000);
server.addConnector(http);

// === Configure SSL KeyStore, TrustStore, and Ciphers ===
SslContextFactory sslContextFactory = new SslContextFactory.Server();
sslContextFactory.setKeyStorePath("/path/to/keystore");
sslContextFactory.setKeyStorePassword("changeme");
sslContextFactory.setKeyManagerPassword("changeme");
sslContextFactory.setTrustStorePath("/path/to/truststore");
sslContextFactory.setTrustStorePassword("changeme");
// OPTIONAL - for client certificate auth (both are not needed)
// sslContextFactory.getWantClientAuth(true)
// sslContextFactory.setNeedClientAuth(true)

// === SSL HTTP Configuration ===
HttpConfiguration https_config = new HttpConfiguration(http_config);
https_config.addCustomizer(new SecureRequestCustomizer()); // <-- HERE

// == Add SSL Connector ===
ServerConnector sslConnector = new ServerConnector(server,
    new SslConnectionFactory(sslContextFactory,"http/1.1"),
    new HttpConnectionFactory(https_config));
sslConnector.setPort(8443);
server.addConnector(sslConnector);