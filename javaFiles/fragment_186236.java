HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    String input = "{\"id\":\"12345\",\"name\":\"navnath\"}";
    HttpEntity<String> entity = new HttpEntity<>(input, headers);
    ResponseEntity<String> responseEntity = restTemplate.postForEntity("/user/post/create", entity, String.class);
    if (responseEntity.getStatusCode().value() != 200) {
        throw new RuntimeException("Failed : HTTP error code : "
                + responseEntity.getStatusCode().getReasonPhrase());
    }