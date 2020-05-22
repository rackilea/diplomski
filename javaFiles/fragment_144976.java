try {
    JSONObject jsonObject = new JSONObject(result);
    JSONArray jsonArray = jsonObject.getJSONArray("articles");

    for(int i = 0; i < jsonArray.length(); i++) {
        JSONObject articleObject = jsonArray.getJSONObject(i);
        JSONObject sourceObject = articleObject.getJSONObject("source");

        String name = sourceObject.optString("name");
        String url = sourceObject.optString("url");
    }
} catch (JSONException e) {
    e.printStackTrace();
}