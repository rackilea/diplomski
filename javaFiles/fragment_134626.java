JSONObject responseJson = new JSONObject(responseString);
JSONArray jsonArray=responseJson.getJSONArray("errors");
for(int i=0; i<jsonArray.lenght();i++){
  JSONObject jso = jsonArray.getJSONObject(i);
  System.out.println(jso.getString("detail"));
}