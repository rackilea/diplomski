public static JSONObject toJsonObject(String json){
    try {
        return new JSONObject(json);
    } catch (JSONException e) {
        Log.e(TAG, "Invalid JSON string: " + json, e);
        return null;
    }
}