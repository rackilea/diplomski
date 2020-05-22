@Path("/user/{id}{format:(/format/[^/]+?)?}{encoding:(/encoding/[^/]+?)?}")
public Response getUser(
    @PathParam("id") int id,
    @PathParam("format") String format,
    @PathParam("encoding") String encoding) {
    //your code
}