import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("api/ping")
public class MyResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() {
        return "pong!";
    }

    @HEAD
    public Response getHeaders() {
        return Response.status(200).
                header("yourHeaderName", "yourHeaderValue").build();
    }
}