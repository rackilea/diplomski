JSONObject req = reponse.convertToJsonObject();
JSONArray filteredAddresses = new JSONArray();
String filterId = "..."; // put whatever your ID is here

JSONArray unfilteredAddresses = req.getJSONArray("adresses");
for (int i = 0; i < unfilteredAddresses.length(); i++){
    JSONObject addressJson = unfilteredAddresses.getJSONObject(i);
    if (!addressJson.has("osm_id") || !addressJson.getString("osm_id").equals(filterId)){
        filteredAddresses.put(addressJson);
    }
}
req.put("adresses", filteredAddresses);