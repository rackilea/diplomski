import org.springframework.web.client.RestTemplate;
 import org.springframework.web.util.UriComponents;
 import org.springframework.web.util.UriComponentsBuilder;
 import org.springframework.http.ResponseEntity;
 //some more class import may be you need to add
  try {

    UriComponents uriComponents = 
     UriComponentsBuilder.newInstance().scheme("https").host(host).path(url).
     queryParam("url_param1", value).queryParam("another_param", 
     value).build().encode();

    HttpHeaders headers = new HttpHeaders();
    headers.add("SECRETKEY", value);
    HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
    ResponseEntity<List<MyResponseObject>> response = restTemplate.exchange(uriComponents.toUri(), HttpMethod.GET, entity, new ParameterizedTypeReference<List<MyResponseObject>>());

    List<MyResponseObject > responses= response.getBody();

  } catch (Exception e) {
     logger.error(e.getMessage());
  }