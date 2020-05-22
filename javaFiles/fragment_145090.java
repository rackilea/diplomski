@GET
@Path("/{messageId}")
@Produces(MediaType.APPLICATION_JSON)
public Response getMessage(@PathParam("messageId") long id) {
    Map<String, String> map = new HashMap<>();
    map.put("1", "abc");
    map.put("2", "def");
    map.put("3", "ghi");

    return Response.status(Status.OK).entity(map).build();
}