import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("testingservice/")
public class TestingRESTService {

    @GET
    @Path("{requestID}")
    @Produces(MediaType.TEXT_PLAIN)
    public String get(@PathParam("requestID") String requestID) {
        return "\n This is request with ID "+requestID;
    }
}