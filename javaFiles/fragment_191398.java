public class RestServer {

    public static void main(String[] args) throws Exception {

        // Create JAX-RS application.
        final ResourceConfig application = new ResourceConfig()
                .packages("jersey.jetty.embedded")
                .register(JacksonFeature.class);

        ServletContextHandler context 
                 = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        Server jettyServer = new Server(9090);
        jettyServer.setHandler(context);
        ServletHolder jerseyServlet = new ServletHolder(new
                org.glassfish.jersey.servlet.ServletContainer(application));
        jerseyServlet.setInitOrder(0);

        context.addServlet(jerseyServlet, "/*");

        // ... removed property (init-param) to compile. 

        try {
            jettyServer.start();
            jettyServer.join();
        } catch (Exception e) {
            System.out.println("Could not start server");
            e.printStackTrace();
        } finally {
            jettyServer.destroy();
        }
    }
}