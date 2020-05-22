public void run() {
    while (keepProcessing) {
        try {
            ConsumerRecords<byte[], byte[]> records = consumer.poll(100);
            for (ConsumerRecord<byte[], byte[]> record : records) {
                // do processing
                consumer.commitSync();
            }
        } catch (Exception e) {
            logger.error("Couldn't process message", e);
        }
    }
}