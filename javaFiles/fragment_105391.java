ArrayList<String> listdata = new ArrayList<String>();
for(int n = 0; n < jsonArray.length(); n++)
{
    JSONObject object = jsonArray.getJSONObject(n);
    listdata.add(object.optString("nr")); 
}

return listdata;