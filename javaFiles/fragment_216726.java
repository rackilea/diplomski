@Path("/hello")
public class HelloResource {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response displayHello() {
        return Response.ok(new Viewable("/views/hello")).build();
    }

}