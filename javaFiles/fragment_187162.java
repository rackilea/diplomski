@Component
@Path("/hello")
public class Endpoint {

    @GET
    public String message() {
        return "Hello";
    }
}