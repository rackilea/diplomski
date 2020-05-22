public ErpConsumer(CusttableDao custtableDao,KafkaStream<byte[], byte[]> kafkaStream, int threadNumber) {
        this.threadNumber = threadNumber;
        this.kafkaStream = kafkaStream;
        this.objectMapper = new ObjectMapper();
        this.custtableDao = custtableDao;
    }