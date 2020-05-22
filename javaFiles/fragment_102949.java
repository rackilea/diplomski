PropertyHandlerMapping phm = new CustomPropertyHandlerMapping();
        phm.setRequestProcessorFactoryFactory(xmlRpcServerClientRequestProcessorFactoryFactory);

phm.setVoidMethodEnabled(true);
try {
    phm.addHandler("", methodsHandler);
} catch (XmlRpcException e) {
    e.printStackTrace();
}
xmlRpcServer.setHandlerMapping(phm);