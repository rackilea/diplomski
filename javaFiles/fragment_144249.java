Servlet servlet = new MyServlet();
String mapping = "/foo";

    Server server = new Server(0);
    Context servletContext = new Context(server, contextPath, Context.SESSIONS);
    servletContext.addServlet(new ServletHolder(servlet), mapping);
    server.start();

    URL url = new URL("http", "localhost", server.getConnectors()[0].getLocalPort(), "/foo?bar");

    //get the url...assert what you want

    //finally server.stop();