private static final Gson gson = new GsonBuilder()
        .registerTypeAdapter(PriceAndQuantity.class, PriceAndQuantityTypeAdapter.get())
        .create();

public static void main(final String... args)
        throws IOException {
    // It just readers the JSON you've put in the question from a resource package
    try ( final JsonReader jsonReader = Resources.getPackageResourceJsonReader(Q50317182.class, "response.json") ) {
        final Order order = gson.fromJson(jsonReader, Order.class);
        System.out.println(order);
    }
}