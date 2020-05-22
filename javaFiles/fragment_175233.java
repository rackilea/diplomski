@Path("/")
public class TestResource
{
    @Context
    Application application;

    @GET
    public String get() {
        String value = (String)application.getProperties().get("MyProp");
    }
}