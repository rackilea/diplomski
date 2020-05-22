public class CompositeSerializer implements Serializer<Object> {

    private final StringSerializer stringSerializer = new StringSerializer();

    private final IntegerSerializer intSerializer = new IntegerSerializer();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public byte[] serialize(String topic, Object data) {
        return data instanceof Integer ? intSerializer.serialize(topic, (Integer) data)
                : stringSerializer.serialize(topic, (String) data);
    }

    @Override
    public void close() {
    }

}