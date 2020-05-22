// Create the request body as a MultiValueMap
MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();     

body.add("field", "value");

// Note the body object as first parameter!
HttpEntity<?> httpEntity = new HttpEntity<Object>(body, requestHeaders);

MyModel model = restTemplate.exchange("/api/url", HttpMethod.POST, httpEntity, MyModel.class);