@POST
@Produces({ "application/x-protobuf" })
@Path("bookid/{bookNumber}")
public Response findBookByBookId(
    @PathParam("bookNumber") String bookNumber, 
    @QueryParam("searchType") String searchType) {
    return ...
}