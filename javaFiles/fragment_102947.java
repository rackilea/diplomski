public class XmlRpcServerClientRequestProcessorFactoryFactory implements RequestProcessorFactoryFactory {

    @Inject
    private Injector injector;
    @Inject
    public XmlRpcServerClientRequestProcessorFactoryFactory(Injector injector) {
        this.injector = injector;
    }

    @Override
    public RequestProcessorFactory getRequestProcessorFactory(final Class pClass)
            throws XmlRpcException {
        return new RequestProcessorFactory() {
            @SuppressWarnings("unchecked")
            @Override
            public Object getRequestProcessor(XmlRpcRequest pRequest)
                    throws XmlRpcException {
                return injector.getInstance(pClass);
            }
        };
    }
}