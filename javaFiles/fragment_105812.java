for (int i = 0; i < jsonArray.length(); i++)
{
    JSONObject jsonObject = jsonArray.getJSONObject(i);

    JSONObject innerObject = jsonObject.getJSONObject(jsonObject.keys().next().toString());

    /// do something with innerObject which holds aa, bb, cc
}