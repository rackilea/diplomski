@Component
@ApplicationPath(Pathes.APPLICATION_PATH)
public class JerseyConfig extends ResourceConfig {

    @Autowired
    public JerseyConfig(@Value("${server.port}") int port) {
        final BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setHost("localhost:" + port);
        beanConfig.setBasePath(Pathes.APPLICATION_PATH);
        beanConfig.setResourcePackage(myPackages);
        beanConfig.setScan(true);

        register(ApiListingResource.class);
        register(SwaggerSerializers.class);
    }
}