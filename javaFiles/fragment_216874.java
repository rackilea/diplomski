public static Gson createGsonObject() {

        // Formado de data alterado, outro formato não estava convertendo
        // Alterado para setar // na saída devido problema com WebService
        GsonBuilder builder = new GsonBuilder();

....

        //Array
        builder.registerTypeAdapter(List.class, new JsonArrayListDeserializer());

        Gson gson = builder.create();

        return gson;
    }

private static class JsonArrayListDeserializer<T> implements JsonDeserializer<ArrayList<T>>{

    @Override
    public ArrayList<T> deserialize(JsonElement jsonElement, java.lang.reflect.Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        try {

            Gson gson = new Gson();
            TypeToken<ArrayList<T>> token = new TypeToken<ArrayList<T>>() {};
            ArrayList<T> value = gson.fromJson(jsonElement, token.getType());

            return value;
        } catch (ClassCastException e) {
            throw new JsonParseException("Cannot parse json Boolean '"
                    + jsonElement.toString() + "'", e);
        }
    }
}