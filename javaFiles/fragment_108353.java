@Configuration
@Import({DataConf.class})
public class ApplicationConf
{
    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer() {
        return new RepositoryRestConfigurerAdapter() {
            @Override
            public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
                 config.setBasePath("/api"); // !!!
            }
        };
    }
}