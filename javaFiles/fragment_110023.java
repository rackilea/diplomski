@POST
@Produces("application/json")
@Path("bookid/{bookNumber}")
public Response findBookByBookIdAsJson(
    @PathParam("bookNumber") String bookNumber, 
    @QueryParam("searchType") String searchType) {
    return ...;
}