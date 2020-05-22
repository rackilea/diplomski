@Path("config")
public class ConfigResource {

    @Config(PROP_KEY)
    private String propValue;

    @GET
    public String getConfigProp() {
        return propValue;
    }
}