FilterHolder filterHolder = new FilterHolder(CrossOriginFilter.class);
    filterHolder.setInitParameter("allowedOrigins", "*");
    filterHolder.setInitParameter("allowedMethods", "GET, POST");

    ServletContextHandler servletContextHandler;
    servletContextHandler = new ServletContextHandler(webServer, "/", ServletContextHandler.SESSIONS);
    servletContextHandler.addServlet(atmosphereServletHolder, "/atmosphere/*");
    servletContextHandler.addServlet(jerseyServletHolder, "/jersey/*");
    servletContextHandler.addFilter(filterHolder, "/*", null);