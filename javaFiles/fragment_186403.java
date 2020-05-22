@Configuration
public class Config {
     @Bean
     public RestTemplate restTemplate(RestTemplateBuilder builder) {
       return builder.build();
     }
}