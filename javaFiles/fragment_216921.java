public static JsonData fromJson(String json) {
    JsonData data = new JsonData();
    data.deserializeJson(json);
    return data;
}

public static JsonData fromXml(String xml) {
    JsonData data = new JsonData();
    data.deserializeXml(xml);
    return data;
}