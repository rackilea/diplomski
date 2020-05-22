JSONObject questionMark = new JSONObject(jsonString);
    Iterator keys = questionMark.keys();
while(keys.hasNext()) {
    // loop to get the dynamic key
    String currentDynamicKey = (String)keys.next();

    // get the value of the dynamic key
    JSONObject currentDynamicValue = questionMark.getJSONObject(currentDynamicKey);