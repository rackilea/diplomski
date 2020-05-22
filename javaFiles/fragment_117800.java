public KafkaTemplate<String, List<Object>> createTemplate() {

        Map<String, Object> senderProps = senderProps();
ProducerFactory<Integer, String> pf =
          new DefaultKafkaProducerFactory<String, List<Object>>(senderProps);
        KafkaTemplate<String, List<Object>> template = new KafkaTemplate<>(pf);
return template;

 }

 public Map<String, Object> producerProps() {

        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.RETRIES_CONFIG, 0);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
        props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
       props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
       return props;

 }

KafkaTemplate<String, List<Object>> kafkaTemplate;