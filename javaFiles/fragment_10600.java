@Path("/endpoint")
public class EndPoint{

@GET
@Produces(MediaType.TEXT_PLAIN)
public Response getMsg() {
   return Response.status(200).entity("hai!").build();
}
}