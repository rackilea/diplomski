JSONObject jsonObject = new JSONObject(jsonSource);
if (jsonObject.get("contacts") instanceof JSONObject) {
    JSONObject contactsJson = jsonObject.getJSONObject("contacts");
    for (Iterator<String> it = contactsJson.keys(); it.hasNext(); ) {
        String key = it.next();
        JSONObject contactJson = contactsJson.getJSONObject(key);
        // your code to process contact item
    }
} else {
    // Your code to process every contact item
}