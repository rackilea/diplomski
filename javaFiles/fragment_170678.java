JSONArray industryIdentifiers = volumeInfo.getJSONArray("industryIdentifiers");
if (industryIdentifiers.length() == 1) {
    JSONObject obj = industryIdentifiers.getJSONObject(0);
    ISBN = obj.getString("type") + ": " + obj.getString("identifier");
} else if (industryIdentifiers.length() == 2) {
    JSONObject obj1 = industryIdentifiers.getJSONObject(0);
    JSONObject obj2 = industryIdentifiers.getJSONObject(1);
    ISBN = obj1.getString("type") + ": " + obj1.getString("identifier") + " - "
         + obj2.getString("type") + ": " + obj2.getString("identifier");
}