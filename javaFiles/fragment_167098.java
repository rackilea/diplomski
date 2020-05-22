// the request from your question
HttpResponse<JsonNode> request = Unirest.get(URL)
  .header("X-Mashape-Authorization", MASHAPE_AUTH)
  .asJson();

// retrieve the parsed JSONObject from the response
JSONObject myObj = request.getBody().getObject();

// extract fields from the object
String msg = myObj.getString("error_message");
JSONArray results = myObj.getJSONArray();