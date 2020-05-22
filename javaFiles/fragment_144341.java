String city = "undefined";
String country = "undefined";
List<Double> temperatures = new ArrayList<Double>();

try {
    JSONObject object = new JSONObject(builder.toString());
    JSONObject jCity = object.getJSONObject("city");
    city = jCity.getString("name");
    country = jCity.getString("country");

    JSONArray weatherList = object.getJSONArray("list");
    for (int i = 0; i < weatherList.length(); i++) {
        JSONObject listObject = weatherList.getJSONObject(i);
        double temp = listObject.getJSONObject("main").getDouble("temp");
        temperatures.add(temp);
    }

} catch (JSONException e) {
    e.printStackTrace();
}

return new Wrapper(city, country, temperatures);