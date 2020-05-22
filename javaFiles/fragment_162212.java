System.setProperty("javax.net.ssl.trustStore", keyStore);
System.setProperty("javax.net.ssl.keyStore", keyStore);
System.setProperty("javax.net.ssl.keyStorePassword", keyStorePass);

SSLSocketFactory sslFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
socket = (SSLSocket) sslFactory.createSocket(address, port);
socket.startHandshake();