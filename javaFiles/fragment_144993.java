for (int i = 0; i < data.length(); i++)
{
JSONObject c = data.getJSONObject(i);
map = new HashMap<String, String>();
if(isValid(c.getString("image")))
{
map.put("imageID", c.getString("imageID"));
map.put("image", c.getString("image"));
MyArrList.add(map);
}
}