String json_string2 = getIntent().getExtras().getString("json_data");
List<String> lStringList = new ArrayList<>();
try {
      JSONObject lJSONObject = new JSONObject(json_string2);
      JSONArray lJSONArray = lJSONObject.getJSONArray("server_response");
      for (int i = 0; i < lJSONArray.length(); i++)
      {
        lStringList.add(
           lJSONArray.getJSONObject(i).getString("violation"));
      }
}
catch(Exception e)
{
    e.printStackTrace();
}