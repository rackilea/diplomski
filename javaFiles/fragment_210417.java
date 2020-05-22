public class CitiesDeserializer extends JsonDeserializer<Cities> {
    private static final TypeReference<Map<String, City>> TYPE_REFERENCE = new TypeReference<Map<String, City>>() {};

    @Override
    public Cities deserialize(final JsonParser jp, final DeserializationContext ctxt) throws IOException {
        final Map<String, City> map = jp.readValueAs(TYPE_REFERENCE);
        List<City> cities = new ArrayList<>();
        for(Map.Entry<String, City> entry : map.entrySet()) {
            City city = entry.getValue();
            city.setName(entry.getKey());
            cities.add(city);
        }
        return new Cities(cities);
    }
}