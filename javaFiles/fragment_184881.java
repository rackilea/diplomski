Server server = new Server();
ServerConnector pxy = new ServerConnector(server);
pxy.setPort(8080);
server.addConnector(pxy);

// Use ContextHandlerCollection 
ContextHandlerCollection contexts = new ContextHandlerCollection();
// Don't forget to add it to the server!
server.setHandler(contexts);

ServletContextHandler testApp = new ServletContextHandler(contexts, "/",
    ServletContextHandler.NO_SESSIONS);

ServletHolder rootServletHolder = new ServletHolder(root.class);      
ServletHolder testServletHolder = new ServletHolder(test.class);      

testApp.addServlet(rootServletHolder, "/test1/*");
testApp.addServlet(testServletHolder, "/test2/*");


server.setHandler(handlers);
server.start();
server.join();