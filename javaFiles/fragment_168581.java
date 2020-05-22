JSONArray jsonArray = new JSONArray(result);

for (int i = 0; i < jsonArray.length(); i++) {
  JSONArray subArray = jsonArray.getJSONArray(i);
  for (int j = 0; j < subArray.length(); j++) {
    System.out.println(subArray.getString(j));
  }
  System.out.println();
}