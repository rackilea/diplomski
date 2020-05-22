HttpHeaders headers = RestTemplateUtils.addBasicAuth(new HttpHeaders(),
        "test", "test");

headers.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");
headers.set("Accept", MediaType.APPLICATION_XML_VALUE);

UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
    .queryParam("id", "id1234"); 
HttpEntity<String> entity = new HttpEntity<>(headers);
ResponseEntity<String> response = RestTemplateUtils.template.exchange(
        builder.build().encode().toUri(),
        HttpMethod.GET, entity, String.class);