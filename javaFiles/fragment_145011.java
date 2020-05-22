import org.apache.avro.generic.GenericData.Record;
import org.apache.avro.generic.GenericRecord;

KStream<String, GenericAvroSerde> joined =
    inputTopicStartKStream.leftJoin(inputTopicEndKStream,
    (left, right) -> {
             // You can get access to the generic Avro record by
             // casting both left and right values 
             Record leftRecord = (Record) left;
             Record rightRecord = (Record) right;

             // For the original question, you can simply create a new GenericRecord 
             // with the contents of left and right records
             GenericRecord record = new GenericData.Record(schema);
             record.put("left", left);
             record.put("right", right);
    }
    JoinWindows.of(Duration.ofHours(24)),
    Joined.with(
        stringSerde,
        genericAvroSerde,
        genericAvroSerde)
);