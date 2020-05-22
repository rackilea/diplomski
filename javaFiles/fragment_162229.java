Server server = new Server(port);
for(Connector y : server.getConnectors()) {
    for(ConnectionFactory x  : y.getConnectionFactories()) {
        if(x instanceof HttpConnectionFactory) {
            ((HttpConnectionFactory)x).getHttpConfiguration().setSendServerVersion(false);
        }
    }
}