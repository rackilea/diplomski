private static final Gson gson = new GsonBuilder()
        .serializeNulls()
        .registerTypeHierarchyAdapter(JsonValue.class, getJsonValueTypeAdapter())
        .create();

public static void main(final String... args) {
    final JsonValue before = createObjectBuilder()
            .add("boolean", true)
            .add("integer", 3)
            .add("string", "foo")
            .addNull("null")
            .add("array", createArrayBuilder()
                    .add(false)
                    .add(2)
                    .add("bar")
                    .addNull()
                    .build())
            .build();
    System.out.println("before.toString()   = " + before);
    final String json = gson.toJson(before);
    System.out.println("type adapter result = " + json);
    final JsonValue after = gson.fromJson(json, JsonValue.class);
    System.out.println("after.toString()    = " + after);
}