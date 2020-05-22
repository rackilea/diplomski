@POST
@Consumes(MediaType.APPLICATION_JSON)
public Response postJson(String json) {
    String value = null;
    try (JsonReader reader = Json.createReader(new StringReader(json))) {
        JsonObject object = reader.readObject();
        JsonValue jsonValue = object.get("value");
        value = jsonValue.toString();
        System.out.println(value);
    }
    return Response.created(newUri).build();
}