/**
 * Main class.
 *
 */
public class Main {
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://192.168.1.34:8080/myapp/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and in com.example package
        final ResourceConfig rc = new ResourceConfig().packages("com.dummy.mypackage");

        //NEW: register custom ResponseFilter
        rc.register(com.dummy.mypackage.CORSResponseFilter.class);

        // Register Jackson JSON
        rc.packages("org.glassfish.jersey.examples.jackson").register(JacksonFeature.class);

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }
    ...
}