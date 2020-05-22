protected HttpHeaders httpHeader(String encodedApiKey) {
 /***/
 restTemplate.setMessageConverters(getMessageConverters());
 ResponseEntity<Tickets> responseEntity = restTemplate.exchange(awsUri,
 HttpMethod.GET,
 httpEntity, new ParameterizedTypeReference<Tickets>() {}); 
}

private List<HttpMessageConverter<?>> getMessageConverters() {
    List<HttpMessageConverter<?>> converters = 
      new ArrayList<HttpMessageConverter<?>>();
    converters.add(new MappingJackson2HttpMessageConverter());
    return converters;
}