String str = "{\"randomName\":{\"id\":22600348,\"name\":\"Ateuzz\",\"profileIconId\":546,\"summonerLevel\":30,\"revisionDate\":1378316614000}}";
JSONObject json = new JSONObject(str);
Iterator<?> keys = json.keys();
while(keys.hasNext())
{
    String key = (String)keys.next();
    Details test = new ObjectMapper().readValue(json.getJSONObject(key).toString(), Details.class);

}