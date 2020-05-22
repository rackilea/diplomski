JSONObject json = new JSONObject(
    "{\"members\":[[\"sd2840d\",\"Johny\"],[\"jkld341\",\"Marry\"]]}");

JSONArray array = json.getJSONArray("members");

for (int idx = 0; idx != array.length(); idx++) {
  JSONArray array2 = array.getJSONArray(idx);
  System.out.println(array2.getString(0));
  System.out.println(array2.getString(1));
}