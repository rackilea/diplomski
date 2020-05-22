deserialize() {
    ColorResponse response = new ColorResponse();
    List<Color> colors = new ArrayList<>();
    response.setName(json.getAsJsonObject().get("name").asString());
    for (Entry<String, JsonElement> entry : json.entrySet()) {
        if (!entry.getKey().equals("name")) {
           colors.add(new Color(entry.getKey(), entry.getValue()));
        }
    }
}