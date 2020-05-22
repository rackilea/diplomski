public <T> Optional<T> get(String url, Class<T> responseType) {
    String fullUrl = url;
    LOG.info("Retrieving data from url: "+fullUrl);
        HttpHeaders headers = new HttpHeaders();

       headers.setAccept(ImmutableList.of(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Basic " + httpAuthCredentials);

        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<T> exchange = restTemplate.exchange(fullUrl, HttpMethod.GET, request, responseType);
        if(exchange !=null)
            return Optional.of(exchange.getBody());
     return Optional.empty();
}