@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "pl.hypeapp.episodie.configuration")
@EnableAdminServer
@EnableJpaRepositories(basePackages = {"pl.hypeapp.episodie.dataproviders"})
@EntityScan(basePackages = {"pl.hypeapp.core.entity"})
public class EpisodieApiApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(EpisodieApiApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    return builder.sources(EpisodieApiApplication.class);
     }
}