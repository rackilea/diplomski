HttpClientRequest request = httpClient.request(HttpMethod.GET, "localhost", "/");
request.setHost("myHost");
System.out.println(request.getHost());
// returns "myHost"
System.out.println(((HttpClientRequestBase)request).host());
//returns "localhost"