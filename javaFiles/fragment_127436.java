public void getKey(String response) {
    List<String> keyList = new ArrayList<String>();
    try {
        JSONObject jsonObject = new JSONObject(response);
        JSONObject schema = jsonObject.getJSONObject("schema");
        JSONObject properties = schema.getJSONObject("properties");
        Iterator iterator = properties.keys();
        while (iterator.hasNext()) {
            String key = iterator.next().toString();
            keyList.add(key);
        }
        String[] arr = (String[]) keyList.toArray(new String[keyList.size()]);
    } catch (JSONException e) {
        e.printStackTrace();
    }
}