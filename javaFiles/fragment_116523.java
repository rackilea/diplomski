public static void main(String[] args)
{
    Map<String, Object> keyValue = new HashMap<>();
    keyValue.put("key1", "value1");
    keyValue.put("key2", "value2");
    keyValue.put("key3", new Integer(10));
    SomeClass sc = new SomeClass("id1", keyValue);

    try {
        new ObjectMapper().writeValue(System.out, sc);
    } catch (IOException e) {
        e.printStackTrace();
    }
}