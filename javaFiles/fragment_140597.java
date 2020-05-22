XmlRpcSun15HttpTransportFactorytransportFactory transportFactory = 
    new XmlRpcSun15HttpTransportFactory(client);

transportFactory.setProxy(proxy); // <= Proxy settings here

client.setTransportFactory(transportFactory);