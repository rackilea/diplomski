Iterator < ? > keys = jObject.keys();

while (keys.hasNext()) {
    String key = (String) keys.next();
    if (jObject.get(key) instanceof JSONObject) {
    }
}