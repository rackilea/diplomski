SslContextFactory sslContextFactory = new SslContextFactory();
HttpConfiguration httpConfig = new HttpConfiguration();

SslConnectionFactory ssl = new SslConnectionFactory(sslContextFactory, "alpn");
ALPNServerConnectionFactory alpn = new ALPNServerConnectionFactory("spdy/3", "http/1.1");
alpn.setDefaultProtocol("http/1.1");
HTTPSPDYServerConnectionFactory spdy = new HTTPSPDYServerConnectionFactory(SPDY.V3, httpConfig);
HttpConnectionFactory http = new HttpConnectionFactory(httpConfig);

Server server = new Server();
ServerConnector connector = new ServerConnector(server, new ConnectionFactory[]{ssl, alpn, spdy, http});

server.start();