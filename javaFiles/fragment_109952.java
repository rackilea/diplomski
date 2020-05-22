public class KTableMerge {

protected Topology buildTopology() {
    final StreamsBuilder builder = new StreamsBuilder();

    //Streams
    KStream<String, RecordA> recordAKStream = builder.stream("test-record-a");
    KStream<String, RecordB> recordBKStream = builder.stream("test-record-b");
    KStream<String, RecordC> recordCKStream = builder.stream("test-record-c");

    //Re-key and Merge Streams in parent 'Record' container
    KStream<String, Record> mergedStream =
        recordAKStream
            .selectKey((key, value) -> value.getForeignKey())
            .mapValues(value -> (Record) value)
            .merge(recordBKStream
                .selectKey((key, value) -> value.getForeignKey())
                .mapValues(value -> (Record) value))
            .merge(recordCKStream
                .selectKey((key, value) -> value.getForeignKey())
                .mapValues(value -> (Record) value));

    //Aggregate
    mergedStream
        .groupByKey()
        .aggregate(
            Merge::new,
            (key, value, aggregate) -> {
                if (value instanceof RecordA) {
                    aggregate.recordA = (RecordA) value;
                } else if (value instanceof RecordB) {
                    aggregate.recordB = (RecordB) value;
                } else if (value instanceof RecordC) {
                    aggregate.recordC = (RecordC) value;
                }
                return aggregate;
            })
        .toStream()
        .to("merge-topic");

    return builder.build();
}

private static class Merge {
    RecordA recordA;
    RecordB recordB;
    RecordC recordC;
}

private interface Record {
    String getForeignKey();
}

private static class RecordA implements Record {
    String id;
    String foreignKey;

    public String getForeignKey() {
        return foreignKey;
    }
}

private static class RecordB implements Record {
    String id;
    String foreignKey;

    public String getForeignKey() {
        return foreignKey;
    }
}

private static class RecordC implements Record {
    String id;
    String foreignKey;

    public String getForeignKey() {
        return foreignKey;
    }
}