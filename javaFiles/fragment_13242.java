@Bean(name = "port1")
public WsPort getPort() {
    WsPort port = new MyWebService().getWsPort();
    addCredentials(port, username1, pass1);
    return port;
}

@Bean(name = "port2")
public WsPort getPort2() {
    WsPort port = new MyWebService().getWsPort();
    addCredentials(port, username2, pass2);
    return port;
}