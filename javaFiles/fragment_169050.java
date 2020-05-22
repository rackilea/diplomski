HttpClient client = HttpClients.createDefault();
HttpPost request = new HttpPost("https://api.pushbots.com/push/all");
request.addHeader("x-pushbots-appid", "54cc...");
request.addHeader("x-pushbots-secret", "1444...");
request.addHeader("Content-Type", "application/json");
request.setEntity(new StringEntity("{your request body here}"));
HttpResponse response = client.execute(request);
int statusCode = response.getStatusLine().getStatusCode();
String responseBody = EntityUtils.toString(response.getEntity());