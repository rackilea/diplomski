@Path("/{fileName: .+}")
@Produces(MediaType.TEXT_HTML)
public class HtmlResource {

    @GET
    public Response getPage(@PathParam("fileName") String fileName) throws IOException {
        URL url = Resources.getResource(fileName);
        return Response.ok(Resources.toString(url, Charsets.UTF_8)).build();
    }
}