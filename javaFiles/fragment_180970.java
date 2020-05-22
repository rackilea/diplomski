JsonParser jsonParser = new JsonParser();
JsonObject jsonObject = jsonParser.parse(jsonString).getAsJsonObject();
Set<String> keys = jsonObject.keySet();
if(keys.contains("age")){
    //Map to one object
} else {
    //Map to the other object
}