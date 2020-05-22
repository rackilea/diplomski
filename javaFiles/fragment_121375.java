// Sessions are bound to a context.
ServletContextHandler context = new ServletContextHandler(null, "/",
   ServletContextHandler.SESSIONS|ServletContextHandler.NO_SECURITY);
server.setHandler(context);  // <-- this is the ServletContext

// Create the SessionHandler (wrapper) to handle the sessions
HashSessionManager manager = new HashSessionManager();
SessionHandler sessions = new SessionHandler(manager);
context.setSessionHandler(sessions); // <-- set the session handler

// set up the servlet
ServletHolder servletHolder = new ServletHolder(Main.MyServlet.class);
context.addServlet(servletHolder, "/*");