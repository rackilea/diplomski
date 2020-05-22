@Path("/")
...
public class BookServiceImpl implements BookService {

    @Path("/{parameter:.*}")
    @GET
    public Response getBooks(@PathParam("parameter") String parameter) {
        if (properties.getProperty("GET").endsWith(parameter) {
            // code to get the books here
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }