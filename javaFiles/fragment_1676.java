JSONObject json = new JSONObject(jsonString);
List<String> usernames = new ArrayList<>();
for (int i = 0; i < json.length(); i++) {
    JSONObject user = json.getJSONObject(i + "");
    usernames.add(user.getString("username"));
}