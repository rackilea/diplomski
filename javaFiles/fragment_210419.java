public class CityDeserialzer extends JsonDeserializer<City> {
    private static final TypeReference<Map<String, List<Room>>> TYPE_REFERENCE = new TypeReference<Map<String, List<Room>>>() {};

    @Override
    public City deserialize(final JsonParser jp, final DeserializationContext ctxt) throws IOException {
        final Map<String, List<Room>> map = jp.readValueAs(TYPE_REFERENCE);
        List<Office> offices = new ArrayList<>();
        for(Map.Entry<String, List<Room>> entry : map.entrySet()) {
            Office office = new Office();
            office.setName(entry.getKey());
            office.setRooms(entry.getValue());
            offices.add(office);
        }
        City city = new City();
        city.setOffices(offices);
        return city;
    }
}