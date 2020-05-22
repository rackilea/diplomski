@Path("service")
public class ServiceResource {

    @Context
    private UriInfo uriInfo;

    @GET
    @Path("definition")
    @Produces("application/xml")
    public Response getDefinition() {
        ServiceDefinition def = new ServiceDefinition();
        UriBuilder b = uriInfo.getBaseUriBuilder();

        def.setKey("childResources");
        def.getMap().put("ab/cd", b.path("ab/cd").build(this).getPath());
        def.getMap().put("xx", b.path("xx").build(this).getPath());

        return Response.ok(def).build();
    }
}