private String getAsString(String key, JsonObject jsonObject) {
    if (jsonObject.get(key).isJsonNull() && !jsonObject.get(key).toString().equals("")) {
        return jsonObject.get(key).getAsString());
    } else {
        return null;
    }
}