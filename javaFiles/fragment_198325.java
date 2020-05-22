public static JSONObject setProperty(JSONObject js1, String keys, String valueNew) throws JSONException {
    String[] keyMain = keys.split("\\.");
    for (String keym : keyMain) {
        Iterator iterator = js1.keys();
        String key = null;
        while (iterator.hasNext()) {
            key = (String) iterator.next();
            if ((js1.optJSONArray(key) == null) && (js1.optJSONObject(key) == null)) {
                if ((key.equals(keym))) {
                    js1.put(key, valueNew);
                    return js1;
                }
            }
            if (js1.optJSONObject(key) != null) {
                if ((key.equals(keym))) {
                    js1 = js1.getJSONObject(key);
                    break;
                }
            }
            if (js1.optJSONArray(key) != null) {
                JSONArray jArray = js1.getJSONArray(key);
                for (int i = 0; i < jArray.length(); i++) {
                    js1 = jArray.getJSONObject(i);
                }
                break;
            }
        }
    }
    return js1;
}

public static void main(String[] args) throws IOException, JSONException {
    FileInputStream inFile = new FileInputStream("/home/ermek/Internship/labs/java/task/test5.json");
    byte[] str = new byte[inFile.available()];
    inFile.read(str);
    String text = new String(str);
    JSONObject json = new JSONObject(text);
    setProperty(json, "rpc_server_type", "555");
    System.out.println(json.toString(4));