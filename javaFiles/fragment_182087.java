WebServer server = new WebServer(80);
 XmlRpcServer xmlRpcServer = server.getXmlRpcServer();
 PropertyHandlerMapping phm = new PropertyHandlerMapping();
 phm.addHandler("test", JavaServer.class);
 xmlRpcServer.setHandlerMapping(phm);
 XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();
    serverConfig.setEnabledForExceptions(true);
    serverConfig.setEnabledForExtensions(true); //Add this line
 server.start();