public <T extends Content> ArrayList<T> parseJSON(String jsonString, Class<T> contentClass) {
    ArrayList<T> contents = new ArrayList<>();

    JSONArray jsonArr = null;
    Gson gson = new Gson();
    try {
        jsonArr = new JSONArray(jsonString);
        for(int i = 0; i < jsonArr.length(); i++) {
            JSONObject jsonObj = jsonArr.getJSONObject(i);
            T content = gson.fromJson(jsonObj.toString(), contentClass);
            contents.add(content);
        }

    } catch (JSONException e) {
        e.printStackTrace();
    }

    return contents;
}