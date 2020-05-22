@POST
@Path("query")
@Produces(MediaType.APPLICATION_JSON)
public Response myMethod(@FormParam("id") String id) {
  if (/* error */) {
    return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();
  }
  return Response.ok().entity(new MyObject(/* ... */)).build();
}