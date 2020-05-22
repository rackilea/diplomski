// retrieve app access token
RestTemplate restTemplate = new RestTemplate();
String result = restTemplate.getForObject("https://graph.facebook.com/oauth/access_token?grant_type=client_credentials&client_id=<app_id>&client_secret=<app_secret>",  String.class);
String appAccessToken = result.replaceAll("access_token=", "");

// create the request       
FacebookTemplate appRequestTemplate = new FacebookTemplate(appAccessToken);
String userId = "1234567890";
MultiValueMap<String, Object> requestData = new LinkedMultiValueMap<String, Object>();
requestData.set("message", "Sending a request through to you...");
String resultOfApprequest = appRequestTemplate.publish(userId, "apprequests", requestData);