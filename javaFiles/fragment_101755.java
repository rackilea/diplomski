public static void main(String[] args) {
    System.setProperty("javax.net.ssl.keyStore", "keystore");
    System.setProperty("javax.net.ssl.keyStorePassword", "password");
    SSLServerSocket server = (SSLServerSocket)null;
    if(ipSocket == null){
        ipSocket = new HashMap<String,java.net.Socket>();
    }

    try {
        SSLServerSocketFactory sslserversocketfactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        // Creates a socket with a default backlog of 50 - meaning
        // There will be a maximum of 50 client connection attempts on this 
        // socket after-which connections will be refused. If the server is
        // overwhelmed by more than that number of requests before they can be
        // accepted, they will be refused
        // The API allows for you to speccify a backlog.
        server = (SSLServerSocket) sslserversocketfactory.createServerSocket(4380);
        log.info("Server started");
    } catch(IOException e) {
        e.printStackTrace();
    }

    while(true){
        try {
            // This will take one of the waiting connections
            SSLSocket client = (SSLSocket) server.accept();
            log.info("new client");
            // HERE is where you should create a thread to execute the
            // conversation with the client.
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}