JsonDeserializer<String[]> deserializer = new JsonDeserializer<String[]>() {

    @Override
    public String[] deserialize(JsonElement jsonElem, Type type,
            JsonDeserializationContext context) throws JsonParseException {

        if(jsonElem == null) {
            return null;
        }

        return jsonElem.getAsString().split(", ");
    }

};

Gson gson = new GsonBuilder()
                    .registerTypeAdapter(String[].class, deserializer)
                    .create();

Type listType = new TypeToken<ArrayList<MyClass>>() {}.getType();
List<MyClass> t = gson.fromJson(json, listType);