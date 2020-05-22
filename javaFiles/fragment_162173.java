try {
  JSONArray mJsonArray = new JSONArray(jsonStr);
  int length = mJsonArray.length();
  for (int i = 0; i < length; i++) {
    JSONObject mJsonObject = mJsonArray.getJSONObject(i);
    ...
    String name = mJsonObject.getString("name");
    JSONArray mJsonArrayProperty = mJsonObject.getJSONArray("properties");
    int innerLength = mJsonArrayProperty.length();
    for (int k = 0; k < innerLength; k++) {
      JSONObject mJsonObjectProperty = mJsonArrayProperty.getJSONObject(k);
      String prop_name = mJsonObjectProperty.getString("prop_name");
      String address = mJsonObjectProperty.getString("address");
      ...
      // hashmap for single contact
      HashMap<String, String> contact = new HashMap<String, String>();
      // adding each child node to HashMap key => value
      contact.put(TAG_EMAIL, prop_name);
      contact.put(TAG_NAME, name);
      contact.put(TAG_PHONE, address);
      // adding contact to contact list
      contactList.add(contact);
    }
  }
} catch (JSONException e) {
  e.printStackTrace();
}
...