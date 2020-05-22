System.setProperty("javax.net.ssl.trustStore", keyStore);
System.setProperty("javax.net.ssl.keyStore", keyStore);
System.setProperty("javax.net.ssl.keyStorePassword", keyStorePass);

SSLServerSocketFactory sslFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
serverSocket = (SSLServerSocket) sslFactory.createServerSocket(port, queueLength);

Socket clientConnection = socket.accept();