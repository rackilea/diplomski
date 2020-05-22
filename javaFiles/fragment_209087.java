@Configuration   
@PropertySource("file:#{contextParameters.envi.dir}/application.properties")//location of your property file
public class AppConfig {

        @Value("${db.url}")
        private String url;

        @Value("${db.username}")
        private String username;

        @Value("${db.password}")
        private String password;

        //other bean configuration
        //..
        @Bean
        static PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
            return new PropertySourcesPlaceholderConfigurer();
        }

}