JSONObject jsonObject = new JSONObject(responseString);
JSONArray array = (JSONArray) jsonObject.get("results");

JSONObject mJsonObject = new JSONObject();

for (int i = 0; i < array.length() ; i++)
{
    mJsonObject = (JSONObject)array.get(i);
    System.out.println(mJsonObject);



}