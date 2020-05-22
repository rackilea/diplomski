public static Map<String, List<String>> toMap(String jsonSTR) {

    Map<String, List<String>> result = new HashMap<>();
    JSONObject jsonObj = new JSONObject(jsonSTR);

    JSONArray schema = jsonObj.getJSONArray("schema");
    JSONArray data = jsonObj.getJSONArray("data");

    for (int i = 0; i < schema.length(); i++) {

        String key = schema.get(i).toString();
        result.put(key, new ArrayList<>());

        for (int j = 0; j < data.length(); j++)
            result.get(key).add(((JSONArray)data.get(j)).get(i).toString());

    }
    return result;
}