public class Example {
    public static void main(String[] args) {
        Example example = new Example();
        example.other = new Other();

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        System.out.println(gson.toJson(example));
    }

    @JsonAdapter(value = OtherAdapter.class)
    @Expose(serialize = true)
    private Other other;
}

class Other {
}

class OtherAdapter extends TypeAdapter<Other> {

    @Override
    public void write(JsonWriter out, Other value) throws IOException {
        System.out.println("hey");
        out.endObject();
    }

    @Override
    public Other read(JsonReader in) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }
}