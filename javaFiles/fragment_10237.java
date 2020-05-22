@Path("first")
public class FirstResource {

    @GET
    public String first() {
        return "first";
    }
}