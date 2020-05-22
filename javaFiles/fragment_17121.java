private static HttpServer startServer() throws IOException {
        LOG.info("Starting server...");
        ResourceConfig rc = new PackagesResourceConfig("com.mycomp.resources");
        rc.getContainerResponseFilters().add(new com.sun.jersey.server.linking.LinkFilter());
        return GrizzlyServerFactory.createHttpServer(BASE_URI, rc);
    }