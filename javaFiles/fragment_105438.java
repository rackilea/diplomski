final Gson gson = new GsonBuilder()
        .registerTypeAdapter(JsonObject.class, new JavaxJsonObjConverter())
        .create();
final JsonObject src = Json.createObjectBuilder()
        .add("foo", "bar")
        .build();
System.out.println(gson.toJson(src.get("foo"), JsonObject.class));