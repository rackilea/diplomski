@Path("/sampleService")
public class SampleService{
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @POST
    @Path("/v1/hello")

    public Response sayHello( SomeObject someobject ) {