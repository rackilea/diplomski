@Path("books")
public class BookService {

    private static final List<Book> library = Arrays.asList(
            new Book(1, "War and Peace", "Novel"),
            new Book(2, "A Game of Thrones", "Fantasy")
    );

    @GET
    @Path("all")
    @JsonView(BookViews.BookBrief.class)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBooks() {
        return Response.status(Response.Status.OK).entity(library).build();
    }

    @GET
    @Path("previews")
    @JsonView(BookViews.BookPreview.class)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBookPreviews() {
        return Response.status(Response.Status.OK).entity(library).build();
    }

}