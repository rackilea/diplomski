private JSONArray concatArray(JSONArray... arrs)
        throws JSONException {
    JSONArray result = new JSONArray();
    for (JSONArray arr : arrs) {
        for (int i = 0; i < arr.length(); i++) {
            result.put(arr.get(i));
        }
    }
    return result;
}