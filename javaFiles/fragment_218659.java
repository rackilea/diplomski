public Map<String, JSONArray> getJsonArrayAsMapOnPageId(JSONArray inputArr) throws JSONException {
    //Map holding pageid : [{company:"",pageview:"",visitfreq:""}, ... , ...] mappings
    Map<String, JSONArray> idMap = new HashMap<String, JSONArray>();

    for (int i=0; i < inputArr.length(); i++) {
        JSONObject inputObj = inputArr.getJSONObject(i);

        String id = inputObj.getString("pageid");

        JSONArray jObjList;
        if (idMap.containsKey(id)) {
            //append to existing list in the Map
            jObjList = idMap.get(id);
        } else {
            //create new list
            jObjList = new JSONArray();
        }

        JSONObject newJsonObj = new JSONObject();
        newJsonObj.put("company", inputObj.get("company"));
        newJsonObj.put("pageview", inputObj.get("pageview"));
        newJsonObj.put("visitfreq", inputObj.get("visitfreq"));

        jObjList.put(newJsonObj);

        idMap.put(id, jObjList);
    }

    return idMap;
}