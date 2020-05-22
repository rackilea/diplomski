private static final Gson gson = new GsonBuilder()
        .setPrettyPrinting()
        .create();

public static void main(final String... args) {
    final JsonObject npcDefinition = new JsonObject();
    npcDefinition.addProperty("New", "Tester");
    npcDefinition.addProperty("B", "Test");
    npcDefinition.addProperty("A", "Test");
    npcDefinition.addProperty("Test", "Tester");
    final JsonArray npcDefinitions = new JsonArray();
    npcDefinitions.add(npcDefinition);
    final String json = gson.toJson(npcDefinitions);
    System.out.println(json);
}