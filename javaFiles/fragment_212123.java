import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Collections;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

class Scratch {

  public static void main(String[] args) {

    RestTemplate rest = new RestTemplate(
        new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));

    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");
    headers.add("Accept", "application/json");
    HttpEntity<String> requestEntity = new HttpEntity<>(headers);

    UriComponentsBuilder builder = null;
    try {
      builder = UriComponentsBuilder.fromUriString("http://example.com/endpoint")
          .queryParam("param1", URLEncoder.encode("abc+123=", "UTF-8"));
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    URI uri = builder.build(true).toUri();
    ResponseEntity responseEntity = rest.exchange(uri, HttpMethod.GET, requestEntity, String.class);
  }

}