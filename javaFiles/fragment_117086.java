class StatusSerializer implements JsonSerializer<Status> {
    public JsonElement serialize(Status status, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        object.addProperty("ID", status.getId());
        object.addProperty("name", status.getName());
        return object;
    }
}