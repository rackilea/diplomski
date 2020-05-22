@Path("/something")
public class MyApp {
    @GET
    @Path("/runApp")
    public Response runApp() {
        return Response.ok("Running app").build();
    }

    @GET
    @Path("/stopApp")
    public Response stopApp() {
        return Response.ok("Stopping app").build();
    }

    @GET
    @Path("/doSomethingElse") {
        return Response.ok("Doing something else").build();
    }
}