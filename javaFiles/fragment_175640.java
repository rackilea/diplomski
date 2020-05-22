import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/account")
public class Account
{

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String info(){
        return "This is the Account RESTful API";
    }

    @GET
    @Path("/getit")
    @Produces(MediaType.TEXT_PLAIN)
    public String getit(){
        System.out.println("Got it!");
        return "Got it!";
    }

}