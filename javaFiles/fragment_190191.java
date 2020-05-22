JSONObject rootObject = (JSONObject)new JSONTokener(yourJsonString).nextValue();
JSONObject responseObject = rootObject.getJSONObject("response");
JSONArray cityArray = responseObject.getJSONArray("results");
List<String> listWithCityNames = new ArrayList<String>();

for(int i = 0; i< cityArray.lenght();i++){
  listWithCityNames.add(cityArray.getJSONObject(i).getString("name"));

 }

for(String city:listWithCityNames){
   System.out.println(city);
 }