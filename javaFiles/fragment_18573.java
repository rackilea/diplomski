jsonResponse = "";
JSONArray ressources = response.getJSONArray("resources");
for (int i = 0; i < jsonarray.length(); i++) {
    String name = ressources.getJSONObject(i).getJSONObject("resource").getJSONObject("fields").getString("name");
    String price = ressources.getJSONObject(i).getJSONObject("resource").getJSONObject("fields").getString("price");
    String symbol = ressources.getJSONObject(i).getJSONObject("resource").getJSONObject("fields").getString("symbol");
    String timeStamp = ressources.getJSONObject(i).getJSONObject("resource").getJSONObject("fields").getString("ts");


    jsonResponse += "Name: " + name + "\n\n";
    jsonResponse += "Price: " + price + "\n\n";
    jsonResponse += "Symbol: " + symbol + "\n\n";
    jsonResponse += "Time Stamp: " + ts + "\n\n";
}

txtResponse.setText(jsonResponse);