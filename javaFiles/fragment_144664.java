public static void main(String[] args) {

    String json = "[{\"blobJson\":\"x\",\"deviceMfg\":10,\"eventCode\":0,\"sensorClass\":3,\"sensorUUID\":\"136199\",\"timeStamp\":1.483384640123117E9,\"uID\":\"136199_3_10\"},{\"blobJson\":\"x\",\"deviceMfg\":10,\"eventCode\":0,\"sensorClass\":3,\"sensorUUID\":\"136199\",\"timeStamp\":1.483379834470379E9,\"uID\":\"136199_3_10\"},{\"blobJson\":\"x\",\"deviceMfg\":10,\"eventCode\":0,\"sensorClass\":3,\"sensorUUID\":\"136199\",\"timeStamp\":1.483384639621985E9,\"uID\":\"136199_3_10\"}]";

    JsonParser jp = new JsonParser();
    JsonElement root = jp.parse(json);
    JsonArray rootArr = root.getAsJsonArray();

    JsonObject rootObj = rootArr.get(0).getAsJsonObject();
    rootObj.entrySet().forEach(entry -> System.out.println(entry.getKey()+": "+entry.getValue().getAsString()));

}