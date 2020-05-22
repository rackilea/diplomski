try
{
    JSONArray myArr = new JSONArray(result);
    JSONObject myObj = myArr.getJSONObject(0);
    int id = myObj.getInt("id");
}
catch (JSONException e) 
{
    e.printStackTrace();
}