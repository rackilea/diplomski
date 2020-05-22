String uriString = "http://128.128.4.120:8080/GCMService/GCMBroadcast";
URIBuilder uriBuilder = new URIBuilder(uriString);
uriBuilder.addParameter("mymsg", "HELLO SERVER");
DefaultHttpClient httpClient = new DefaultHttpClient();
HttpPut httpPut = new HttpPut(uriBuilder.build());
HttpResponse resp = httpClient.execute(httpPut);