public static class Field {
    public String name;

    // Use @JsonAdapter(MyJsonAdapter.class)
    // or register serializer and deserializer in
    // new GsonBuilder().registerTypeAdapter(new MyJsonAdapter())
    @JsonAdapter(MyJsonAdapter.class)
    public List<String> value; // need to change value type to list
}