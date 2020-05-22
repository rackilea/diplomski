JSONObject json = new JSONObject(jsonAsString);
JSONArray jArray = json.getJSONArray("rootTag");
for (int i = 0; i < jArray.length(); i++)
{
    JSONObject currentJ = jArray.getJSONObject(i);
    //Do Something with the object
}