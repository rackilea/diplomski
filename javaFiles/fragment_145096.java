private static final Type responseItemListType = new TypeToken<List<MyEntity>>() {
}.getType();

private static final Gson gson = new GsonBuilder()
        .registerTypeAdapterFactory(getAlwaysListTypeAdapterFactory())
        .create();

public static void main(final String... args) {
    test("");
    test("{\"id\":1,\"name\":\"name\"}");
    test("[{\"id\":1,\"name\":\"name\"},{\"id\":1,\"name\":\"name\"}]");
    test("[]");
}

private static void test(final String incomingJson) {
    final List<MyEntity> list = gson.fromJson(incomingJson, responseItemListType);
    System.out.print("LIST=");
    System.out.println(list);
    System.out.print("JSON=");
    gson.toJson(list, responseItemListType, System.out); // no need to create an intermediate string, let it just stream
    System.out.println();
    System.out.println("-----------------------------------");
}