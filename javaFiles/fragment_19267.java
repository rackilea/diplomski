TProcessorFactory processorFactory = new TProcessorFactory(null)
{
    public TProcessor getProcessor(TTransport trans)
    {
        return new X.Processor<XHandler>(new XHandler());
    }
};
TServer server = new TSimpleServer(new TServer.Args(serverTransport)
    .processorFactory(processorFactory));