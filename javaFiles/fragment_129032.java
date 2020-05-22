MyWebService service = new MyWebService();
MyWebServicePortType client = service.MyWebServicePort();

Client cl = ClientProxy.getClient(client);

HTTPConduit http = (HTTPConduit) cl.getConduit();

HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
httpClientPolicy.setConnectionTimeout(0);
httpClientPolicy.setReceiveTimeout(0);

http.setClient(httpClientPolicy);

client.doSomething(...);