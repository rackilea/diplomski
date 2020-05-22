public static void main(String[] args) {
    final String json = "{\n" +
        "    \"object\": {\n" +
        "        \"1\": [{ \"id\" : 111 }],\n" +
        "        \"2\": [{ \"id\" : 222 }],\n" +
        "        \"3\": [{ \"id\" : 333 }]\n" +
        "    }\n" +
        "}\n";
    final Gson gson = new GsonBuilder()
        .create();
    final ObjectWrapper value = gson.fromJson(json, ObjectWrapper.class);

    System.out.println(value.object);
    System.out.println(value.object.keySet());
    System.out.println(value.object.get(1));
}

// This is top-most object we want to deserialize from JSON
static class ObjectWrapper {
    // Didn't bother about proper naming while it is better to give a meaningful name here
    private Map<Integer, List<Element>> object;
}

static class Element {
    // Added this attribute to demonstrate that objects within array are properly read
    private int id;
    @Override
    public String toString() {
        return "{id=" + id + "}";
    }
}