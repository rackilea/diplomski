private static final Gson gson = new GsonBuilder()
        .registerTypeAdapterFactory(getInterfaceTypeAdapterFactory())
        .create();

public static void main(final String... args) {
    final Wrapper before = new Wrapper(new Foo());
    final String json = gson.toJson(before);
    System.out.println(json);
    final Wrapper after = gson.fromJson(json, Wrapper.class);
    System.out.println(after.whatever.getClass());
}