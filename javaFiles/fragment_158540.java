Server server = new Server();
SelectChannelConnector connector = new SelectChannelConnector();
connector.setPort(port);

Context context = new Context(server, "/", Context.SESSIONS);

DispatcherServlet dispatcherServlet = new DispatcherServlet();
dispatcherServlet.setContextConfigLocation("classpath:com/mycompany/config/DefaultServlet-servlet.xml");

ServletHolder servletHolder = new ServletHolder(dispatcherServlet);
context.addServlet(servletHolder, "/*")