final Properties props ...
resourceConfig.register(new AbstractBinder() {
    @Override
    protected void configure() {
        bind(props).to(Properties.class);
    }
});

@Path("config")
public class ConfigResource {

    @Inject
    private Properties properties;

}