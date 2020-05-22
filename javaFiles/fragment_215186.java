import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/service")
@Produces("application/json")
public interface ServiceInterface {

    @Path("/endpoint")
    @GET
    public Response getEndpoint(
            @QueryParam("queryA") String first,
            @QueryParam("queryB") @DefaultValue("default") String second);

}