JSONObject json = new JSONObject(response)
JSONArray jarray = json.getJSONArray("data");
for(int i = 0; i < jarray.length(); i++){
  JSONObject oneAlbum = jarray.getJSONObject(i);
  //get your values
  oneAlbum.getJSONString("name"); // this will return you the album's name.
}