private JSONArray concatArray(JSONArray arr1, JSONArray arr2)
        throws JSONException {
    JSONArray result = new JSONArray();
    for (int i = 0; i < arr1.length(); i++) {
        result.put(arr1.get(i));
    }
    for (int i = 0; i < arr2.length(); i++) {
        result.put(arr2.get(i));
    }
    return result;
}