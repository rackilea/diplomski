@Configuration
@PropertySource("classpath:content-stream.properties")
public class AppConfig {
    @Value("${mail.server.username}")
    private String destinationEmail;

    // getters
}