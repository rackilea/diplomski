try {
        // if your response is { },you can use JSONObject
        JSONObject jsonObject = new JSONObject(response);
        // then find the foods tag in your json data
        JSONArray foods = jsonObject.getJSONArray("foods");
        // loop for the JSONArray
        for (int i = 0; i < foods.length(); i++) {
            // getJSONObject from the index
            JSONObject jsonObject1 = foods.getJSONObject(i);
            // then get full_nutrients tag
            JSONArray full_nutrients = jsonObject1.getJSONArray("full_nutrients");
            // loop for the JSONArray
            for (int j = 0; j < full_nutrients.length(); j++) {
                // getJSONObject from the index again
                JSONObject jsonObject2 = full_nutrients.getJSONObject(i);
                // get attr_id
                String attr_id = jsonObject2.getString("attr_id");
                // get value
                String value = jsonObject2.getString("value");
            }
        }
} catch (JSONException e) {
        e.printStackTrace();
}