try {
    SSLContext ctx = SSLContext.getDefault();
    ctx.getClientSessionContext().setSessionTimeout(5); // in seconds
    SSLSocket socket = (SSLSocket) 
         ctx.getSocketFactory().createSocket("host.com", 443);

    socket.setSoTimeout(5000); // in millis
    socket.startHandshake();
} catch (IOException ex) {
    sslAvailable = false;
}