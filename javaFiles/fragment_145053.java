try {

    JSONObject json = new JSONObject(response);
    JSONArray jArray = json.getJSONArray("Data");
    for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject object = jsonArray.getJSONObject(i);
        symbol.add(object.getString("Symbol"));
        price.add(object.getString("Price"));

    }

} catch (JSONException e) {
    e.printStackTrace();
}