@Path("resource")
public class MyResource {

    @Uri("http://example.com")
    private WebTarget target;

    @GET
    public String sayHello() {
        return target.request().get(String.class);
    }
}