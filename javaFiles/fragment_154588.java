ResourceConfig config = new ResourceConfig();
config.property("host_user","bla bla bla");
...
@Path("myapp")
public class MyHandler
{
    @Context
    Configuration configuration;

    public String action1(@Context Request request, String json) {
        Map<String, Object> props = configuration.getProperties();
    }
}