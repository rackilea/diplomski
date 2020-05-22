public static <K, V> List<ConsumerRecord<K, V>>
    minPoll(KafkaConsumer<K, V> consumer, Duration timeout, int minRecords) {
  List<ConsumerRecord<K, V>> acc = new ArrayList<>();
  long pollTimeout = Duration.ofMillis(timeout.toMillis()/10);
  long start = System.nanoTime();
  do {
    ConsumerRecords<K, V> records = consumer.poll(pollTimeout);
    for(ConsumerRecord<K, V> record : records)
      acc.add(record);
  } while(acc.size() < minRecords &&
          System.nanoTime() - start < timeout.toNanos());
  return acc;
}