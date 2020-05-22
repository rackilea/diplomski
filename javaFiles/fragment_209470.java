@Test
public void testNetClientAndServerSSLDifferentContexts() throws Exception {
    System.setProperty("javax.net.debug", "all"); // SSL activity in the console
    TcpNetServerConnectionFactory server = new TcpNetServerConnectionFactory(0);
    TcpSSLContextSupport serverSslContextSupport = new DefaultTcpSSLContextSupport("server.ks",
            "server.truststore.ks", "secret", "secret");
    DefaultTcpNetSSLSocketFactorySupport serverTcpSocketFactorySupport =
            new DefaultTcpNetSSLSocketFactorySupport(serverSslContextSupport);
    serverTcpSocketFactorySupport.afterPropertiesSet();
    server.setTcpSocketFactorySupport(serverTcpSocketFactorySupport);
    final List<Message<?>> messages = new ArrayList<Message<?>>();
    final CountDownLatch latch = new CountDownLatch(1);
    server.registerListener(new TcpListener() {

        @Override
        public boolean onMessage(Message<?> message) {
            messages.add(message);
            latch.countDown();
            return false;
        }

    });
    server.start();
    TestingUtilities.waitListening(server, null);

    TcpNetClientConnectionFactory client = new TcpNetClientConnectionFactory("localhost", server.getPort());
    TcpSSLContextSupport clientSslContextSupport = new DefaultTcpSSLContextSupport("client.ks",
            "client.truststore.ks", "secret", "secret");
    DefaultTcpNetSSLSocketFactorySupport clientTcpSocketFactorySupport =
            new DefaultTcpNetSSLSocketFactorySupport(clientSslContextSupport);
    clientTcpSocketFactorySupport.afterPropertiesSet();
    client.setTcpSocketFactorySupport(clientTcpSocketFactorySupport);
    client.start();

    TcpConnection connection = client.getConnection();
    connection.send(new GenericMessage<String>("Hello, world!"));
    assertTrue(latch.await(10, TimeUnit.SECONDS));
    assertEquals("Hello, world!", new String((byte[]) messages.get(0).getPayload()));
}