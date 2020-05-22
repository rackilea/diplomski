List<JSONObject> objectsA = ... ;
List<JSONObject> objectsB = ... ;

Map entries = new HashMap<String, JSONObject>();
List<JSONObject> allObjects = new ArrayList<JSONObject>();
allObjects.addAll(objectsA);
allObjects.addAll(objectsB);

for (JSONObject obj: allObjects) {
    String key = obj.getString("id");
    JSONObject existing = entries.get(key);
    if (existing == null) {
        existing = new JSONObject();
        entries.put(key, existing);
    }

    for (String subKey : obj.keys()) {
        existing.put(subKey, obj.get(subKey));
    }
}

List<JSONObject> merged = entries.values();