@POST
@Consumes(MediaType.APPLICATION_JSON)
public Response createBook(@Valid @NoId(idField = "id") Book book) {
    book.setId(1);
    return Response.created(URI.create("http://blah.com/books/1"))
            .entity(book).build();
}