public ArrayList<Data> parseJSON(String json) {

    ArrayList<Data> data = new ArrayList<>();
    // Data item = new Data();  // Move this into for loop

    Log.d(TAG, json);
    try {

        JSONArray jArray = new JSONArray(json);

        for (int i=0; i < jArray.length();i++) {
            Data item = new Data();
            JSONObject jObject = jArray.getJSONObject(i);
            item.setFromCurrency(jObject.getString("from"));
            item.setToCurrency(jObject.getString("to:"));
            item.setRate(jObject.getString("rate"));
            data.add(item);
        }
    } catch (JSONException je) {
        Log.d(TAG, je.getMessage());
    }
    return data;
}