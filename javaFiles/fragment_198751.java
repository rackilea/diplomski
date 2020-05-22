HttpHeaders headers = new HttpHeaders();
headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
        .queryParam("name", "charlie")
        .queryParam("type", "clown")
        .queryParam("age", "35")
        .queryParam("country", "JPA");


HttpEntity<?> entity = new HttpEntity<>(headers);

HttpEntity<String> response = restTemplate.exchange(
        builder.build().encode().toUri(), 
        HttpMethod.GET, 
        entity, 
        String.class);