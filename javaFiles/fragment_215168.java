HttpPost request = new HttpPost(Config.urlJSON);
StringEntity params = new StringEntity(json.toString());
request.addHeader("content-type", "application/json");
request.setEntity(params);
int statusCode = httpClient.execute(request).getStatusLine().getStatusCode();
Log.debug("[STATUS:[" + String.valueOf(statusCode) + "]");