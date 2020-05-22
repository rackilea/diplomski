HttpGet request = new HttpGet(url);
String authorizationString = "Basic " + Base64.getEncoder().encodeToString(("myUser:myPass").getBytes()).replace("\n", "");             
request.setHeader(HttpHeaders.AUTHORIZATION, authorizationString);

HttpClient client = HttpClientBuilder.create().build();
HttpResponse response = client.execute(request);

System.out.println(response.getStatusLine().toString());