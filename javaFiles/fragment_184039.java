try {
    HttpHeaders headers = new HttpHeaders();
    // add some headers
    HttpEntity<String> request = new HttpEntity<String>(headers);    
    ResponseEntity<List<UserPreference>> response = restTemplate.exchange(
        YOUR_URL, HttpMethod.GET, request, new ParameterizedTypeReference<List<UserPreference>>() {});
    List<UserPreference> userPerference = response.getBody();
} catch (HttpStatusCodeException e) {
    String errorBody = e.getResponseBodyAsString();
}