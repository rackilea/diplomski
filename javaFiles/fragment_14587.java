try (ServerSocket testSocket = new ServerSocket(0)) {
    int randomFreePort = testSocket.getLocalPort(); 
    sslConnector.setPort(randomFreePort);
    defaultConnector.setRedirectPort( randomFreePort);
} // At this point the testSocket.close() called
tomcat.start();