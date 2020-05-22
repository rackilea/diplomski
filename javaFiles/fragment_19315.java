public static void main(String[] args) {
    ObjectMapper mapper = new ObjectMapper();

    // serialization - ignore field
    try {
        MyWrapper w = new Foo("value");
        String json = mapper.writeValueAsString(w);
        System.out.println("serialized MyWrapper: " + json);
    } catch (Exception e) {
        e.printStackTrace();
    }

    // de-serialization - read field
    String json = "{\"my_field\":\"value\"}";
    try (InputStream is = new ByteArrayInputStream(json.getBytes("UTF-8"))) {
        MyWrapper w = (MyWrapper)mapper.readValue(is, Foo.class);
        System.out.println("deserialized MyWrapper: input: " + json + " ; w.getMyField(): " + w.getMyField());
    } catch (Exception e) {
        e.printStackTrace();
    }
}