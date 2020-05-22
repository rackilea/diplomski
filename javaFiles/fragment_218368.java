@Path("/example")
public class MyEndpoint {

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response myUnsecuredMethod(@PathParam("id") Long id) {
        // This method is not annotated with @Secured
        // The security filter won't be executed before invoking this method
        ...
    }

    @DELETE
    @Secured
    @Path("{id}")
    @Produces("application/json")
    public Response mySecuredMethod(@PathParam("id") Long id) {
        // This method is annotated with @Secured
        // The security filter will be executed before invoking this method
        ...
    }
}