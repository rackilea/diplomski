@Path("foo")
public class FooResource {

    @GET
    @Path("done")
    public String getDone(@QueryParam("message") String message) {
        return message;
    }

    @POST
    @Path("submit")
    public Response postData() {
        String message = UriComponent.encode(
                "You have perefected submitting!", 
                UriComponent.Type.QUERY_PARAM_SPACE_ENCODED);
        return Response.seeOther(URI.create("/api/foo/done?message=" + message)).build();
    }
}