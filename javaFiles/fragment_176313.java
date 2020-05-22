try {
    JSONObject jsonObject = new JSONObject(theJsonString);
    Iterator keys = jsonObject.keys();
    Map<String, String> map = new HashMap<String, String>();
    while (keys.hasNext()) {
        String key = (String) keys.next();
        map.put(key, jsonObject.getString(key));
    }
    System.out.println(map);// this map will contain your json stuff
} catch (JSONException e) {
    e.printStackTrace();
}