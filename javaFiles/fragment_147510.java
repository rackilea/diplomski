JSONArray cities = json.getJSONArray("city");
JSONObject city = null;
String[] s = new String[cities.length()];

for (int i = 0; i < cities.length(); i++)
{
    city = cities.getJsonObject(i);
    s[i] = city.get("name");
}