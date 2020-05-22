Type type = new TypeToken<MyDS>() {}.getType();
Gson gson = new GsonBuilder()
    .registerTypeAdapter(Map.Entry.class, new MapEntryDeserializer())
    .create();

MyDS myDS = gson.fromJson(json, type);