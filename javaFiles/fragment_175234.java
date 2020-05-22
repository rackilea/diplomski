@Path("/")
public class TestResource
{
    @Context
    Configuration config;

    @GET
    public String get() {
        String value = (String)config.getProperty("MyProp");
    }
}