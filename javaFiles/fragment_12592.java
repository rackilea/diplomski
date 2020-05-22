public class MapAppenderSerializer
        extends StdSerializer<Map>
        implements ContextualSerializer {
    private static final long serialVersionUID = 1L;

    private final String[] keys;
    private final String[] values;

    // No-arg constructor required for Jackson
    MapAppenderSerializer() {
        super(Map.class);
        keys = new String[0];
        values = new String[0];
    }

    MapAppenderSerializer(
            final String[] keys,
            final String[] values) {
        super(Map.class);
        this.keys = keys;
        this.values = values;
    }

    @Override
    public void serialize(
            final Map value,
            final JsonGenerator jsonGenerator,
            final SerializerProvider serializerProvider) throws IOException {
        // Create a copy Map to avoid touching the original one
        final Map hashMap = new HashMap<>(value);

        // Add the annotation-specified key-value pairs
        for (int i = 0; i < keys.length; i++) {
            hashMap.put(keys[i], values[i]);
        }

        // Serialize the new Map
        serializerProvider.defaultSerializeValue(hashMap, jsonGenerator);
    }

    @Override
    public JsonSerializer<?> createContextual(
            final SerializerProvider serializerProvider,
            final BeanProperty property) {
        MapAppender annotation = null;

        if (property != null) {
            annotation = property.getAnnotation(MapAppender.class);
        }

        if (annotation != null) {
            return new MapAppenderSerializer(annotation.keys(), annotation.values());
        }

        throw new UnsupportedOperationException("...");
    }
}