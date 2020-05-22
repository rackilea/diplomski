@Path("/foo")
public class SomeResource {

    @Context
    private UriInfo uriInfo;

    @GET
    public Response someMethod() {
        MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
        ...
    }
}