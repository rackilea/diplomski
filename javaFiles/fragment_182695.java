ResourceConfig rc = new ResourceConfig();
rc.packages("com.danny.resources");
rc.registerInstances(new StatusModule(useFake), new NetworkModule(useFake));
GrizzlyHttpContainer resourceConfigContainer = ContainerFactory
    .createContainer(GrizzlyHttpContainer.class, rc);
HttpServer server = GrizzlyHttpServerFactory.createHttpServer(baseUri);
server.getServerConfiguration().addHttpHandler(resourceConfigContainer, "/");