JSONObject json = new JSONObject(jsonString);
JSONArray owners = (JSONArray) json.get("owners");

Iterator<String> iterator = owners.iterator();
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}