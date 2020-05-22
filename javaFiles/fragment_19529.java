@Configuration
public class DbConfiguration {

    @Bean
    public MovieDao dao() {
        return new MovieDao();
    }

    @Bean
    public MovieService service(MovieDao dao) {
        return new MovieService(dao);
    }

}