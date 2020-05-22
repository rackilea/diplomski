for (int i = 0; i < jsonarray.length(); i++) {

    JSONObject resource = ressources.getJSONObject(i).getJSONObject("resource");
    JSONObject fields = getJSONObject("fields");

    jsonResponse += "Name: " + fields.getString("name") + "\n\n";
    jsonResponse += "Price: " + fields.getString("price") + "\n\n";
    jsonResponse += "Symbol: " + fields.getString("symbol") + "\n\n";
    jsonResponse += "Time Stamp: " + fields.getString("ts") + "\n\n";
}