final String url = "http://codeflex.co:8080/rest/Management/login";

RestTemplate template = new RestTemplate();
Credentials cred = new Credentials();
cred.setUserName("admin@codeflex.co");
cred.setPassword("godmode");

HttpEntity<Credentials> request = new HttpEntity<>(cred);       
HttpEntity<String> response = template.exchange(url, HttpMethod.POST, request, String.class);
HttpHeaders headers = response.getHeaders();
String set_cookie = headers.getFirst(HttpHeaders.SET_COOKIE);