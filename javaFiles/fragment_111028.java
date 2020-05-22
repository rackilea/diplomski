final class PriceAndQuantityTypeAdapter
        extends TypeAdapter<PriceAndQuantity> {

    private static final TypeAdapter<PriceAndQuantity> instance = new PriceAndQuantityTypeAdapter()
            .nullSafe();

    private PriceAndQuantityTypeAdapter() {
    }

    static TypeAdapter<PriceAndQuantity> get() {
        return instance;
    }

    @Override
    public void write(final JsonWriter out, final PriceAndQuantity value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public PriceAndQuantity read(final JsonReader in)
            throws IOException {
        in.beginArray();
        final double price = in.nextDouble(); // Indicated as PRICE in the documentation
        final double quantity = in.nextDouble(); // Indicated as QTY in the documentation
        // BEGIN alternative to in.skipValue()
        // JsonReader.skipValue consumes any JSON literal,
        // but here we assert a sequence of [ and ] explicitly
        in.beginArray();
        in.endArray();
        // END alternative to in.skipValue()
        in.endArray();
        return PriceAndQuantity.of(price, quantity);
    }

}