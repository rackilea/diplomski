System.setProperty("javax.net.ssl.keyStore",
            "/home/foo/.keystore/client.ks");
    System.setProperty("javax.net.ssl.keyStorePassword", "changeme");
    System.setProperty("javax.net.ssl.trustStore",
            "/home/foo/.keystore/client.ts");

    StompConnection connection = new StompConnection();
    SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory
            .getDefault();
    SSLSocket sslsocket = (SSLSocket) factory.createSocket("127.0.0.1",
            61612);
    connection.open(sslsocket);