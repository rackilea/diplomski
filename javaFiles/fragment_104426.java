MultiValueMap<String, Object> variables = new LinkedMultiValueMap<>();
variables.add("country", "Teacher 1");
variables.add("issuerName", "Department 1");

RestTemplate restTemplate = new RestTemplate();

HttpHeaders requestHeaders = new HttpHeaders();
requestHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(variables, requestHeaders);

String url = txtHost.getText()+txtGet.getText();
ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Issuer.class);