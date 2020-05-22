@Stateless
@Path("query")
public class QueryApi {
   @Path("/helloworld")
   @GET
   @Produces({MediaType.APPLICATION_JSON})
   public String test(){
     return new String("Hello World!!!");
   }
}