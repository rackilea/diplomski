@Service
public class RestClientConfig {

    @Value("${your.config.value}")
    private String yourValue;


    private final RestTemplate restTemplate = new RestTemplate();

    @Bean
    public RestTemplate restTemplate() {
      // Configure it, using your imported values
      // ...

      return restTemplate;
   }
}