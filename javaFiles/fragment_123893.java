String url = "http://localhost:8080/mgm/country";
List<MediaType> mediaTypes = new ArrayList<MediaType>();
mediaTypes.add(MediaType.APPLICATION_JSON);
HttpHeaders headers = new HttpHeaders();
headers.setAccept(mediaTypes);
HttpEntity<Country> httpEntity = new HttpEntity<Country>(null, headers);
try {
    ResponseEntity<Country[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Country[].class);
    Country[] countries = responseEntity.getBody();
    System.out.println(countries[0].getName());

} catch (RestClientException exception) {
    exception.printStackTrace();
}