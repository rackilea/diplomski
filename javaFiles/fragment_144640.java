Server server = new Server();

val connector = new SelectChannelConnector();
connector.setPort(4567);
server.addConnector(connector);

val thr = new SomeThriftServlet();

val ct0 = new ServletContextHandler(ServletContextHandler.SESSIONS);
ct0.setContextPath("/thr");
ct0.addServlet(new ServletHolder(thr), "/*");

val rsc = new ResourceHandler();
rsc.setDirectoriesListed(true);
rsc.setWelcomeFiles(new String[]{ "index.html" });
rsc.setResourceBase(".");

val ct1 = new ContextHandler();
ct1.setContextPath("/rsc");
ct1.setHandler(rsc);

val contexts = new ContextHandlerCollection();
contexts.setHandlers(new Handler[] {ct0, ct1, new DefaultHandler() });

server.setHandler(contexts);

server.start();
server.join();