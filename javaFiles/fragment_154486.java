@Component
@Path("/jersey")
public class JerseyController {

    @GET
    @Produces("application/json")
    public String health() {
        System.out.println("Here");
        return "Jersey: Up and Running!";
    }
}