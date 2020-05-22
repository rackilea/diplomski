JSONArray jArray = new JSONArray (result);
for(int i=0; I<jArray.length; i++){
   JSONObject jObject = jArray.getJSONObject(i);

   String name = jObject.getString("name");
}