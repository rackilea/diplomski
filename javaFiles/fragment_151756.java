import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/jerseytest")
public class Server
{
    @Context private UriInfo uriInfo;

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String get()
    {
        System.out.println("jerseytest called: URI = " + uriInfo.getRequestUri());

        return "<response>hello world</response>";
    }
}