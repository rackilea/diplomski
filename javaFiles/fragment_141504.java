public class MockDB {

    private JSONObject json;

    public MockDB() {
        this.json = fillJSON();
    }

    // fill JSON object with test data
    private JSONObject fillJSON() {
        JSONObject json = new JSONObject();

        JSONObject map = new JSONObject();
        map.put("data", Arrays.asList(1));
        json.put("a", map);

        map = new JSONObject();
        map.put("data", Arrays.asList(11));
        json.put("b", map);

        return json;
    }

    public JSONObject getJSON() {
        return cloneJson(json);
    }

    public void setJSON(JSONObject newJson) {
        this.json = cloneJson(newJson);
    }

    // make a deep copy of JSON object
    private JSONObject cloneJson(JSONObject jsonObj) {
        JSONObject newJson = new JSONObject();
        for(Object key : jsonObj.keySet()) {
            if (jsonObj.get(key) instanceof JSONObject) {
                newJson.put(key, cloneJson((JSONObject) jsonObj.get(key)));
            } else if (jsonObj.get(key) instanceof JSONArray) {
                newJson.put(key, ((JSONArray)jsonObj.get(key)).clone());
            } else {
                newJson.put(key, jsonObj.get(key));
            }
        }
        return newJson;
    }
}