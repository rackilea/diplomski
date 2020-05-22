JsonObject root = new JsonParser().parse(jsonStr).getAsJsonObject();
JsonArray dayArr = root.getAsJsonObject("daily").getAsJsonArray("data");
for (JsonElement elem : dayArr) {
    JsonObject elemObj = elem.getAsJsonObject();
    System.out.println(elemObj.getAsJsonPrimitive("icon") + "\t" +
            elemObj.getAsJsonPrimitive("temperatureMin") + "\t" +
            elemObj.getAsJsonPrimitive("temperatureMax"));
}