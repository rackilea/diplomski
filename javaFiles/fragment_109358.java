RestTemplate restTemplate = new RestTemplate();

HttpHeaders headers = new HttpHeaders();
headers.set("token", Params.token);

HttpEntity<String> entity = new HttpEntity<>(username, headers);

restTemplate.postForObject("http://myurl.com/rest/user/getbyusername/{username}",
        entity,
        User.class);