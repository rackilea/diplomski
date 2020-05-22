import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;


@Configuration
public class SpringConfiguration {

  @Bean
  public HttpClient httpClient() {
    RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(30 * 1000).build();
    return HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();
  }

}