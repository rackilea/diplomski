Server server = new Server();

Connector connector = new SelectChannelConnector();
connector.setPort(8080);
server.setConnectors(new Connector[]{connector});

WebAppContext webappcontext = new WebAppContext();
webappcontext.setContextPath("/mywebapp");
webappcontext.setWar("./path/to/my/war/orExplodedwar");

HandlerCollection handlers= new HandlerCollection();
handlers.setHandlers(new Handler[]{webappcontext, new DefaultHandler()});

server.setHandler(handlers);
HashUserRealm myrealm = new HashUserRealm("MyRealm",System.getProperty("jetty.home")+"/etc/realm.properties");
server.setUserRealms(new UserRealm[]{myrealm});

server.start();
server.join();