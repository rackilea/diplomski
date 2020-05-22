public class NettyXmlRpcModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(NettyXmlRpcModule.class);
        bind(XmlRpcServerClientRequestProcessorFactoryFactory.class).in(Singleton.class);
        bind(Integer.TYPE).annotatedWith(Names.named("xmlrpc.port")).toInstance(3133);
    }


    @Provides
    @Singleton
    Log providesLog(){
        return LogFactory.getLog(NettyXmlRpcWebServer.class);
    }

    @Provides
    InetAddress providesInetAddress() throws UnknownHostException {
        return InetAddress.getLocalHost();
    }
}