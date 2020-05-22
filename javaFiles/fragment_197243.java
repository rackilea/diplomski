GsonBuilder b = new GsonBuilder();

b.registerTypeAdapter(WallResponse.class,new JsonDeserializer<WallResponse>() {

@Override
public WallResponse deserialize(JsonElement jsonElement,Type typeOf, JsonDeserializationContext context)  throws JsonParseException {

    final Gson g = new Gson();

    final JsonObject jsonObject = jsonElement.getAsJsonObject();

    final WallResponse wallResponse = new WallResponse(new Response());                                         
    final Entry<String, JsonElement> entry = jsonObject.entrySet().iterator().next();
    final JsonElement element = entry.getValue();
    final JsonObject jsonObject2 = element.getAsJsonObject();

    final Entry<String, JsonElement> entry2 = jsonObject2.entrySet().iterator().next();
    final JsonArray jsonArray = entry2.getValue().getAsJsonArray();
    final Iterator<JsonElement> jsonElement2 = jsonArray.iterator();
    int totalRecord=-1;

    while (jsonElement2.hasNext()) {
        final JsonElement element2 = jsonElement2.next();
        if (element2.isJsonPrimitive())
            totalRecord=element2.getAsInt();
        if (element2.isJsonObject()) {
            final Wall wall = g.fromJson(element2, Wall.class);
            wall.setTotalRecord(totalRecord);
            List<Wall> walls= new ArrayList<>();
            walls.add(wall);
            wallResponse.getResponse().setWall(walls);
        }
    }


    return wallResponse;
  }
});

WallResponse response = b.create().fromJson(reader, WallResponse.class);