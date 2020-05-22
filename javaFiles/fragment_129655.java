public void loadProcesses(){
    // the username and password to access the rest API (same as for UI)
    String plainCreds = "username:p@ssword";
    byte[] plainCredsBytes = plainCreds.getBytes();
    byte[] base64CredsBytes = Base64.getEncoder().encode(plainCredsBytes);
    String base64Creds = new String(base64CredsBytes);

    HttpHeaders headers = new HttpHeaders();
    headers.add("Authorization", "Basic " + base64Creds);
    RestTemplate restTemplate = new RestTemplate();
    HttpEntity<String> request = new HttpEntity<>(headers);
    ResponseEntity<String> responseAsJson = restTemplate.exchange("http://localhost:8080/activiti-rest/repository/process-definitions", HttpMethod.GET, request, String.class);
}