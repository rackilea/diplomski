abstract class AbstractJsonStreamTest
        implements ITest {

    protected static void read(final JsonReader jsonReader, final Consumer<? super City> cityConsumer)
            throws IOException {
        jsonReader.beginArray();
        while ( jsonReader.hasNext() ) {
            jsonReader.beginObject();
            require(jsonReader, "country");
            final String country = jsonReader.nextString();
            require(jsonReader, "name");
            final String name = jsonReader.nextString();
            require(jsonReader, "_id");
            final int id = jsonReader.nextInt();
            require(jsonReader, "coord");
            jsonReader.beginObject();
            require(jsonReader, "lon");
            final double longitude = jsonReader.nextDouble();
            require(jsonReader, "lat");
            final double latitude = jsonReader.nextDouble();
            jsonReader.endObject();
            jsonReader.endObject();
            final City city = City.of(id, country, name, Coordinates.of(latitude, longitude));
            cityConsumer.accept(city);
        }
        jsonReader.endArray();
    }

    private static void require(final JsonReader jsonReader, final String expectedName)
            throws IOException {
        final String actualName = jsonReader.nextName();
        if ( !actualName.equals(expectedName) ) {
            throw new JsonParseException("Expected " + expectedName + " but was " + actualName);
        }
    }

}