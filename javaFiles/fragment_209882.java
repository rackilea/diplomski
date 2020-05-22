JSONObject myJsonObject = 
    new JSONObject("{\"null_object_1\":[],\"null_object_2\":[null]}");

if (myJsonObject.getJSONArray("null_object_1").length() == 0) {
    ... 
}