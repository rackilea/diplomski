public String parse(String jsonLine) {
    JsonElement jelement = new JsonParser().parse(jsonLine);
    JsonObject  jobject = jelement.getAsJsonObject();
    jobject = jobject.getAsJsonObject("data");
    JsonArray jarray = jobject.getAsJsonArray("translations");
    jobject = jarray.get(0).getAsJsonObject();
    String result = jobject.get("translatedText").getAsString();
    return result;
}