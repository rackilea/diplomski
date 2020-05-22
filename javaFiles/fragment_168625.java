@Configuration
public class MyAppConfig {

  @Bean
  public RestTemplate restTemplate() {
      RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory());
      restTemplate.setInterceptors(Collections.singletonList(new JsonMimeInterceptor()));
      return restTemplate;
  }
}