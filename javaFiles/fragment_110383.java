private JSONObject modifyPrices(JSONObject JSONObj) {
    try {
        JSONObject supplyPrice = JSONObj.getJSONObject("supplyPrice");
        JSONArray supplyPriceArray = new JSONArray();
        Iterator<?> keys = supplyPrice.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            String value = supplyPrice.getString(key);
            supplyPriceArray.put(new JSONObject("{\"name\":" + key + ",\"value\":" + value + "}"));
        }
        JSONObj.put("supplyPrice", supplyPriceArray);
        return JSONObj;
    } catch (JSONException e) {
        e.printStackTrace();
    }
    return null;
}