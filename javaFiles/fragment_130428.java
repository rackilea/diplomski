JSONArray store_array = product_details_json.getJSONObject("data").getJSONArray("stores");

for (int i = store_array.length() - 1; i >= 0; i--){
    JSONObject store = store_array.getJSONObject(i);
    Object storeData = store.get(store.keys().next());
    boolean isValidStore = storeData instanceof JSONObject
            && ((JSONObject) storeData).has("product_store");
    if (!isValidStore) {
        store_array.remove(i);
    }
}