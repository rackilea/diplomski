// searchResult refers to the current element in the array "search_result"
JSONObject questionMark = searchResult.getJSONObject("question_mark");
Iterator keys = questionMark.keys();

while(keys.hasNext()) {
    // loop to get the dynamic key
    String currentDynamicKey = (String)keys.next();

    // get the value of the dynamic key
    JSONObject currentDynamicValue = questionMark.getJSONObject(currentDynamicKey);

    // do something here with the value...
}