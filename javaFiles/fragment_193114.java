JSONObject json;
Object     intervention;
JSONArray  interventionJsonArray;
JSONObject interventionObject;

json = RestManager.getJSONfromURL(myuri); // retrieve the entire json stream     
Object intervention = json.get("intervention");
if (intervention instanceof JSONArray) {
    // It's an array
    interventionJsonArray = (JSONArray)intervention;
}
else if (intervention instanceof JSONObject) {
    // It's an object
    interventionObject = (JSONObject)intervention;
}
else {
    // It's something else, like a string or number
}