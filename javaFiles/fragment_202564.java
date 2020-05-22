@Path("/restservice")
public class RestService {
        @Context
        UriInfo uriInfo;
        @Context
        Request request;
        String id;

        @GET
        @Path("/{name}")
        @Produces(MediaType.TEXT_PLAIN)
        public String sayHello(@PathParam("name") String name){
            return "Hello " + name;
        }

}