TNonblockingTransport transport = new TNonblockingSocket("127.0.0.1", 9160);
TAsyncClientManager clientManager = new TAsyncClientManager();
TProtocolFactory protocolFactory = new TBinaryProtocol.Factory();
Cassandra.AsyncClient client = new Cassandra.AsyncClient(protocolFactory, clientManager, transport);

Cassandra.method_call(parameters, new Callback());