Set<Map.Entry<String, JsonValue>> kvPairs = jsonObject.entrySet();
if (kvPairs.size() == 1) {
    for (Map.Entry<String, JsonValue> kvPair: kvPairs) {
        if (kvPair.getKey().equals("key1")) {
            // success
        } else {
            // error handling
        }
    }
} else {
    // error handling
}