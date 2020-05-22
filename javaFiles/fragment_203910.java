@Data
class JsonTestClass {
    Boolean active = new Boolean(true);
    Integer id;
}

class BooleanJsonDeserializer implements JsonDeserializer<Boolean> {
    @Override
    public Boolean deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonPrimitive jsonPrimitive = json.getAsJsonPrimitive();
        if (jsonPrimitive.isBoolean()) {
            return jsonPrimitive.getAsBoolean();
        } else {
            return jsonPrimitive.getAsInt() == 0 ? false : true;
        }
    }
}

// TempJson
public static void main(String[] args) throws Exception {
    Gson gson = new GsonBuilder()
            .registerTypeAdapter(Boolean.class, new BooleanJsonDeserializer()).create();

    System.out.println(gson.fromJson("{id:12345,active:1}", JsonTestClass.class).getActive());
    System.out.println(gson.fromJson("{id:12345,active:0}", JsonTestClass.class).getActive());
    System.out.println(gson.fromJson("{id:12345,active:false}", JsonTestClass.class).getActive());
    System.out.println(gson.fromJson("{id:12345,active:true}", JsonTestClass.class).getActive());
}