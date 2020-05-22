JSONObject rates = object.getJSONObject("rates");
Iterator<String> iterator = rates.keys();
while (iterator.hasNext()) {
    String keyDate = iterator.next(); // the date
    String cad = rates.getJSONObject(keyDate).getString("CAD"); // the numeric
}