@Path("second")
public class SecondResource {

    @GET
    public String first() {
        return "second";
    }
}