@Configuration
public class MyConfiguration extends RepositoryRestMvcConfiguration {

    @Override
    protected void repositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(User.class);
    }
}