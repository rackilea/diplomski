@Path("/")
...
public class BookServiceImpl implements BookService {

    @Path("/")
    @GET
    public Response getBooksByRoot(@QueryParam("format") String format) {
        return getBooks(format);
    }

    @Path("/library")
    @GET 
    public Response getBooksByLibrary(@QueryParam("format") String format) {
        return getBooks(format);
    }

    private Response getBooks(String format) {
        ...
    }

    @Path("/library")
    @POST 
    public Response createBook(@QueryParam("name") String name) {
        ...
    }