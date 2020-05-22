import org.json.*;

JSONObject obj = new JSONObject(" yourJSONObjectHere ");

JSONArray arr = obj.getJSONArray("networkArray");
for (int i = 0; i < arr.length(); i++)
{
    String networkCode = arr.getJSONObject(i).getString("networkCode");
    ......
}