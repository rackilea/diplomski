public class KafkaIntegrationTest {

private int consumersAndPartitionsNumber;
private final CountDownLatch latch = new CountDownLatch(consumersAndPartitionsNumber);

@Test
public void testPartitions() throws Exception {
    consumersAndPartitionsNumber = Config.getConsumerThreadAmount(); // it's 5
    KafkaMessageQueue kafkaMessageQueue = new KafkaMessageQueue(); // just a class with Producer configuration
    String groupId = Config.getGroupId();
    List<KafkaConsumer<byte[], byte[]>> consumers = new ArrayList<>(consumersAndPartitionsNumber);

    for (int i = 0; i < consumersAndPartitionsNumber; i++) {
        consumers.add(spy(new KafkaConsumer<>(KafkaManager.createKafkaConsumerConfig(groupId))));
    }

    ExecutorService executor = Executors.newFixedThreadPool(consumersAndPartitionsNumber);
    for (KafkaConsumer<byte[], byte[]> consumer : consumers) {
        executor.submit(new TestKafkaWorker(consumer));
    }

    for (int i = 0; i < consumersAndPartitionsNumber; i++) {
        // send messages to topic
        kafkaMessageQueue.send(new PostMessage("pageid", "channel", "token", "POST", null, "{}"));
    }

    latch.await(60, TimeUnit.SECONDS);

    for (KafkaConsumer<byte[], byte[]> consumer : consumers) {
        verify(consumer).commitSync();
    }
}

class TestKafkaWorker implements Runnable {

    private final KafkaConsumer<byte[], byte[]> consumer;
    private boolean keepProcessing = true;

    TestKafkaWorker(KafkaConsumer<byte[], byte[]> consumer) {
        this.consumer = consumer;
        consumer.subscribe(Arrays.asList(Config.getTaskProcessingTopic()));
    }

    public void run() {
        while (keepProcessing) {
            try {
                ConsumerRecords<byte[], byte[]> records = consumer.poll(100);
                for (ConsumerRecord<byte[], byte[]> record : records) {
                    consumer.commitSync();
                    keepProcessing = false;
                    latch.countDown();
                }
            } catch (Exception e) {
            }
        }
    }
}
}