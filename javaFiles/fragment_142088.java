@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/rest/someResource")
public class MyResource()
{
     @Path("/{resourceId")
     @GET
     public Response getResource(@PathParam("resourceId") String id)
     {
          doStuffAndReturnResponse();
     }
}