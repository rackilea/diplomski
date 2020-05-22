HttpHeaders headers = new HttpHeaders();
headers.setContentType(MediaType.APPLICATION_JSON);
HttpEntity<?> httpEntity = new HttpEntity<Object>(payLoad, headers);

ResponseEntity<ResponseObject> response = restTemplate.exchange(ENDPOINT, HttpMethod.POST, httpEntity, ResponseObject.class);
ResponseObject resObj =  response.getBody();