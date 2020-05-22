Map<String, String> generatorMap = new LinkedHashMap<String, String>();
try {
    JsonElement jelement = new JsonParser().parse(jsonLine);

    JsonArray jarray1 = jelement.getAsJsonArray();
    JsonObject rootObject = (JsonObject) jarray1.get(0);
    JsonArray specValues = rootObject.getAsJsonArray("specValues");

    JsonObject first = (JsonObject) specValues.get(0);
    JsonObject second = (JsonObject) specValues.get(1);

    String result1 = first.get("englishValue").toString();
    generatorMap.put("Running Watts", result1);
    String result2 = second.get("englishValue").toString();
    generatorMap.put("Starting Watts", result2);
    return generatorMap;
} catch (Exception e) {
    log.error(e.getMessage());
    return generatorMap;
}