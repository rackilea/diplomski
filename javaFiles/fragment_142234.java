I have used restTemplate.exchange but you can modify to use postForEntity 
 or postForObject. Hope this helps.

 private HttpHeaders createHttpHeaders() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    return headers;
    }

@RequestMapping("/testClient")
public String testClient() {
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = createHttpHeaders();
    HttpEntity<String> entity = new HttpEntity<String>("parameters",
            headers);
    ResponseEntity<String> response = restTemplate.exchange(url,
            HttpMethod.GET, entity, String.class);
    if (response.getStatusCode().equals(HttpStatus.OK)) {
        System.out.println("getbody -" + response.getBody());
    }
    return "Test Client";
}