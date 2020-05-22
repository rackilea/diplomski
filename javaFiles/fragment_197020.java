public InetSocketAddress(String hostname, int port) {
    if (port < 0 || port > 0xFFFF) {
        throw new IllegalArgumentException("port out of range:" + port);
    }   
    if (hostname == null) {
        throw new IllegalArgumentException("hostname can't be null");
    }   
    try {
        addr = InetAddress.getByName(hostname);
    } catch(UnknownHostException e) {
        this.hostname = hostname;
        addr = null;
    }   
    this.port = port;
}