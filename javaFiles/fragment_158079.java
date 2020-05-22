RestTemplate restTemplate = new RestTemplate();
HttpHeaders headers = new HttpHeaders();
headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

MultiValueMap<String, String> bodyParamMap = new LinkedMultiValueMap<>();
bodyParamMap.add("grant_type", "client_credentials");
bodyParamMap.add("client_id", "nu5yzeth9tektzf5egxuntp7");
bodyParamMap.add("client_secret", "uP2Xvr6SCKYgXgxxJsv2QkUG");

entity = new HttpEntity<>(bodyParamMap, headers);

restTemplate.postForEntity(url, entity, TokenDTO.class)