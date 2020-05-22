JSONElement jsonElem = new JsonParser().parse(result);
if(jsonElem.isJsonArray()) {
    // Normal data
} else {
    // 'Error' data'
}