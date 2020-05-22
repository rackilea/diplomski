public class AddPartition <R extends ConnectRecord<R>> implements Transformation<R> {

    public static final ConfigDef CONFIG_DEF = new ConfigDef();

    @Override
    public void configure(Map<String, ?> props) {
        final SimpleConfig config = new SimpleConfig(CONFIG_DEF, props);
    }

    @Override
    public R apply(R record) {
        return record.newRecord(record.topic(), calculatePartition(record), record.keySchema(), record.key(), record.valueSchema(), record.value(), record.timestamp());
    }

    private Integer calculatePartition(R record) {
        // Partitions calcuation based on record information
        return 0;
    }

    @Override
    public void close() {
    }

    @Override
    public ConfigDef config() {
        return CONFIG_DEF;
    }
}