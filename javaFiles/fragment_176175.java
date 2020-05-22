public JsonObject toJson(String value) {
    return new JsonParser().parse(value).getAsJsonObject();
}

// (probably dosen't require a method)
public String fromJson(JsonObject json) {
    return json.toString();
}