@Autowired
private RestTemplate restTemplate;

public List<Info> getInfo() throws RestClientException, URISyntaxException {
    HttpEntity<?> httpEntity = new HttpEntity<>(null, new HttpHeaders());

    ResponseEntity<Info[]> resp = restTemplate.exchange(
            new URI(BASE_URL + "/Info"), HttpMethod.GET, 
            httpEntity, Info[].class);
    return Arrays.asList(resp.getBody());
}