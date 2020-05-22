jsonResponse = new JSONObject(json.toString());
jsonResponse = jsonResponse.getJSONObject("response");
// products found
// Getting Array of Products
cinemas = jsonResponse.getJSONArray(TAG_PRODUCTS);//response

// looping through All Products
for (int i = 0; i < cinemas.length(); i++) {
    JSONObject venueObject = cinemas.getJSONObject(i);
    String name = venueObject.getString(TAG_NAME);
    JSONObject location = venueObject. getJSONObject(TAG_LOCATION);
    String countryCode = location.getString("cc");

    prgmName.add(name);
}