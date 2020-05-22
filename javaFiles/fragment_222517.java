JSONObject mergeTarget = source.getJSONObject(propertyName);
Iterator<String> keys = newData.keys();

while (keys.hasNext()) {
    String key = keys.next();
    mergeTarget.put(key, newData.get(key));
}