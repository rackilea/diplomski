Resource jettyConfig = Resource.newSystemResource("jetty.xml");
XmlConfiguration configuration = new XmlConfiguration(jettyConfig.getInputStream());
Server server = (Server)configuration.configure();

WebAppContext wac = new WebAppContext();
wac.setResourceBase(".");
wac.setDescriptor("WEB-INF/web.xml");
wac.setContextPath("/");
wac.setParentLoaderPriority(true);
server.setHandler(wac);

server.start();