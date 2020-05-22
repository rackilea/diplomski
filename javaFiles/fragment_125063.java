public class ContentBase {

  public static void main(String[] args) throws Exception {

    Properties properties = new Properties();
    properties.setProperty("bootstrap.servers", "kf-service:9092");
    properties.setProperty("group.id", "varnost-content");

    // Setup up execution environment and get stream from Kafka
    StreamExecutionEnvironment see = StreamExecutionEnvironment.getExecutionEnvironment();
    DataStream<ObjectNode> logs = see.addSource(new FlinkKafkaConsumer011<>("log-input",
                    new JSONKeyValueDeserializationSchema(false), properties).setStartFromLatest())
            .map((MapFunction<ObjectNode, ObjectNode>) jsonNodes -> (ObjectNode) jsonNodes.get("value"));


    // Create a new List of Streams, one for each "rule" that is being executed
    // For now, I have a simple custom wrapper on flink's `.filter` function in `MyClass.filter`
    List<String> codes = Arrays.asList("404", "200", "500");
    List<DataStream<ObjectNode>> outputs = new ArrayList<>();
    for (String code : codes) {
      outputs.add(MyClass.filter(logs, "response", code));
    }

    Optional<DataStream<ObjectNode>> alerts = outputs.stream().reduce(DataStream::union);


    // Convert to string and sink to Kafka
    alerts.map((MapFunction<ObjectNode, String>) ObjectNode::toString)
            .addSink(new FlinkKafkaProducer011<>("kf-service:9092", "log-output", new SimpleStringSchema()));
    see.execute();
  }
}