Properties props = new Properties();
    props.put("metadata.broker.list", "localhost:9092");
    props.put("acks", "all");
    props.put("retries", 0);
    props.put("batch.size", 16384);
    props.put("linger.ms", 1);
    props.put("buffer.memory", 33554432);
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    props.put("serializer.class", "kafka.serializer.StringEncoder");
    ProducerConfig producerConfig = new ProducerConfig(props);
    kafka.javaapi.producer.Producer<String, String> producer 
    = new kafka.javaapi.producer.Producer<String, String>(producerConfig);