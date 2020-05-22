DefaultHttpClient httpClient = new DefaultHttpClient();
HttpPost postRequest = new HttpPost("http://solrHost.com:8983/solr/update/json");
StringEntity input = new StringEntity("{\"firstName\":\"Bob\",\"lastName\":\"Williams\"}");
input.setContentType("application/json");
postRequest.setEntity(input);
HttpResponse response = httpClient.execute(postRequest);