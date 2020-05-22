@PUT
@Path("/{id}")
@Accepts("application/json")
public Response putPojo(@PathParam("id") String id, Pojo pojo) {
  return Response.ok().build();
}