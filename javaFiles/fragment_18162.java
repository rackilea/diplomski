public static void main(final String[] args) {

    // Your input is a JSON array, not a JSON object
    final String input = "[{\"key\":\"a\"}, {\"key\":\"b\"}, {\"key\":\"c\"}]";

    // We format it to be a JSON object, so we can parse it
    final MyArray res = Json.decodeValue(String.format("{\"objs\":%s}", input), MyArray.class);

    // Get your List out
    System.out.println(res.objs);
}