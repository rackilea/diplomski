final XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
config.setServerURL(new URL(url));

final XmlRpcTransportFactory transportFactory = new XmlRpcTransportFactory()
{
    public XmlRpcTransport getTransport()
    {
        return new MessageLoggingTransport(client);
    }
};

client = new XmlRpcClient();
client.setTransportFactory(transportFactory);
client.setConfig(config);