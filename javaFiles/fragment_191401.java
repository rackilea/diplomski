import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/json")
public class JsonResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        Resource resource = new Resource();
        resource.hello = "world";
        return Response.ok(resource).build();
    }

    public static class Resource {
        public String hello;
    }
}