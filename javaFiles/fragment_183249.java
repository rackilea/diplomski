/**
 * In order to test the timeout, the resource will be injected into an embedded server.
 * Each endpoint should have a unique use case.
 */
@Path("tests")
public class TestResource {

    @POST
    @Produces({MediaType.APPLICATION_XML})
    @Path("socket-timeout")
    public Response testSocketTimeout() throws InterruptedException {
        Thread.sleep(SOCKET_TIMEOUT_SLEEP);
        return Response.ok().build();
    }
}