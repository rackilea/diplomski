package my.sample;
import io.swagger.annotations.Api;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.core.Response;

@Api
@Path ("/mypath")
public class MyResource
{
    @GET
    public Response myEndpoint()
    {
        return Response.ok ();
    }
}