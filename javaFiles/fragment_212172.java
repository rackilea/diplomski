public static String getAlfTicket(String _userName, String _password) {
String _ticket;
HttpHeaders headers = new HttpHeaders();
headers.setContentType(MediaType.APPLICATION_JSON);
headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
messageConverters.add(new FormHttpMessageConverter());
messageConverters.add(new StringHttpMessageConverter());
messageConverters.add(new MappingJacksonHttpMessageConverter());
RestTemplate restTemplate = new RestTemplate();

restTemplate.setMessageConverters(messageConverters);

String JsonRequest = "{ \"username\": \"" + _userName + "\", \"password\": \"" + _password + "\" }";

HttpEntity<String> requestEntity = new HttpEntity<String>(JsonRequest, headers);

person entity = restTemplate.postForObject("http://yourhost:port/alfresco/service/api/login", requestEntity,
    person.class);

// String path = entity.getHeaders().getLocation().getPath();

System.out.println(entity.getData().getTicket());
_ticket = entity.getData().getTicket();
return _ticket;
  }