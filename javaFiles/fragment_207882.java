Iterator<String> iter = json.keys();
while (iter.hasNext()) {
    String key = iter.next();
    try {
        Object value = json.get(key);
    } catch (JSONException e) {
        // Something went wrong!
    }
}