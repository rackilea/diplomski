CloseableHttpClient httpClient = HttpClients.createDefault();
HttpPost request = new HttpPost("www.example.com");
String json = "{\"value\": {\"id\": \"12345\",\"type\": \"weird\"}}";

StringEntity entity = new StringEntity(json);
entity.setContentType(ContentType.APPLICATION_JSON.getMimeType());

request.setEntity(entity);
request.setHeader("Content-type", "application/json");

HttpResponse resp = client.execute(request);