Gson gson = new GsonBuilder()
    .registerTypeAdapter(Objects.class, new ObjectsDeserializer())
    .registerTypeAdapter(NestedObject2.class, new NestedObject2Deserializer())
    .create();

Objects o = gson.fromJson(new FileReader(new File("file.json")), Objects.class);