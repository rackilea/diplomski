//jsonString is your whole JSONString which you have shown above

JSONObject jObj = new JSONObject(jsonString);
JSONObject jSearchData = jObj.getJSONObject("searchdata");
JSONArray jTitles = jSearchData.getJSONArray("titles");
JSONArray jDesc= jSearchData.getJSONArray("desc");
JSONArray jLinks= jSearchData.getJSONArray("links");
String nextPage = jSearchData.getString("nextpage");
//and so on and so forth