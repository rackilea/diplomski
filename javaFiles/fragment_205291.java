@Configuration
public class RestDataConfig extends RepositoryRestMvcConfiguration{
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config)
    {
        super.configureRepositoryRestConfiguration(config);
        config.exposeIdsFor(Assignment.class);
    }
}