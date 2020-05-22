class MultiJsonReader {

    // constant list of properties for each class
    private final List<String> HEART_PROPS = Arrays.asList("pulse", "rr", "time");
    private final List<String> GPS_PROPS = Arrays.asList("lat", "lon", "distance", "speed", "realTime", "time");

    private final Gson gson;

    public MultiJsonReader(Gson gson) {
        this.gson = gson;
    }

    public List<Object> readAll(File jsonFile) throws IOException {
        List<TypeAdapter<?>> adapters;
        // read first time for finding types and adapters
        try (JsonReader jsonReader = gson.newJsonReader(new FileReader(jsonFile))) {
            jsonReader.setLenient(true);
            adapters = findAdapters(gson, jsonReader);
        }

        List<Object> objects = new ArrayList<>();

        // read second time for deserialising
        try (JsonReader jsonReader = gson.newJsonReader(new FileReader(jsonFile))) {
            jsonReader.setLenient(true);
            for (TypeAdapter<?> adapter : adapters) {
                objects.add(adapter.read(jsonReader));
            }
        }

        return objects;
    }

    private List<TypeAdapter<?>> findAdapters(Gson gson, JsonReader jsonReader) throws IOException {
        List<TypeAdapter<?>> adapters = new ArrayList<>();

        while (jsonReader.peek() != JsonToken.END_DOCUMENT) {
            List<String> names = new ArrayList<>();

            jsonReader.beginObject();
            while (jsonReader.peek() != JsonToken.END_OBJECT) {
                names.add(jsonReader.nextName());
                jsonReader.skipValue();
            }
            jsonReader.endObject();

            Class<?> clazz = getClassForProperties(names);
            adapters.add(gson.getAdapter(clazz));
        }

        return adapters;
    }

    private Class<?> getClassForProperties(List<String> properties) {
        if (HEART_PROPS.containsAll(properties)) {
            return HeartDTO.class;
        }
        if (GPS_PROPS.containsAll(properties)) {
            return GpsDTO.class;
        }

        throw new IllegalArgumentException("Properties are not known " + properties);
    }
}