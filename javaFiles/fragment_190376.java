JSONObject jobj = new JSONObject(jsonData);
JSONArray items = jobj.getJSONArray("items");
Iterator i = items.iterator();
while(i.hasNext())
{
    JSONObject gobj = (JSONObject) i.next();
    JSONObject volumeInfo = gobj.getJSONObject('volumeInfo');
    JSONObject readingModes = volumeInfo.getJSONObject('readingModes');
(...)
}