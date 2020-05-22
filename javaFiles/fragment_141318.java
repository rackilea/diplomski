// your root json object
JSONObject jObject = new JSONObject(result);

// query node
JSONObject queryObject = jObject.getJSONObject("query");

// get all items under search node
JSONArray searchObjects = queryObject.getJSONArray("search");

// iterate over all search items
for(int i = 0; i < searchObjects.length(); i++) {
  // get the current object as json object
  JSONObject searchObject = searchObjects.getJSONObject(i);

  // get the title
  String title = searchObject.getString("title");

  // use the title for what you want...
}