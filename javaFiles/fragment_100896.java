@Path("resource")
public class MyResource {

    @Context
    private Configuration config;

    @GET
    public String sayHello() {
        return ClientBuilder
                   .newBuilder()
                   .withConfig(config)
                   .target("http://example.com")
                   .request().get(String.class);
    }
}