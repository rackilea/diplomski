public class EchoServer {
    public static void main(String[] args) throws Exception {
      WebServer webServer = new WebServer(8080);
      XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer();
      PropertyHandlerMapping phm = new PropertyHandlerMapping();
      EchoService echo = new EchoServiceImpl();
      phm.setRequestProcessorFactoryFactory(new MyRequestProcessorFactoryFactory());
      phm.setVoidMethodEnabled(true);
      phm.addHandler(EchoService.class.getName(), EchoService.class);
      xmlRpcServer.setHandlerMapping(phm);

      XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();
      serverConfig.setEnabledForExtensions(true);
      serverConfig.setContentLengthOptional(false);
      webServer.start();
    }
  }