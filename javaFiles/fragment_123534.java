//It is important that if we are sending a Content-Type application/json, the entity has to receive a json 
JSONObject js = new JSONObject();
js.put("key", value);
String url = "http://mylocalhosturl";
DefaultHttpClient httpClient = new DefaultHttpClient();
HttpPost httpPost = new HttpPost(url);
StringEntity entity = new StringEntity(js.toString(), HTTP.UTF_8);

//Setting the content type is very important
entity.setContentEncoding(HTTP.UTF_8);
entity.setContentType("application/json");
httpPost.setEntity(entity);

//Execute and get the response.
HttpResponse response = httpClient.execute(httpPost);