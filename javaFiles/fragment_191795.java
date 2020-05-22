import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Transformer;
import org.apache.kafka.streams.kstream.TransformerSupplier;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;
import org.apache.kafka.streams.state.StoreBuilder;
import org.apache.kafka.streams.state.Stores;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class Pipe{
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();

        //  setting Configs
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-pipe");
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        // initializing  a streambuilder for building topology.
        final StreamsBuilder builder = new StreamsBuilder();
        // creating a KStream that is continuously generating records from its source kafka topic "streams-plaintext-output"
        KStream<String, String> source = builder.stream("streams-plaintext-input");

        StoreBuilder<KeyValueStore<String, Long>> wordCountsStore = Stores.keyValueStoreBuilder(
                Stores.persistentKeyValueStore("WordCountsStore"),
                Serdes.String(),
                Serdes.Long())
                .withCachingEnabled();

        builder.addStateStore(wordCountsStore);

        source.map((k, v) -> KeyValue.pair("key", v))
                .peek((k, s) -> System.out.printf("After keying: %s, value: %s\n", k, s))
                .transform(new SampleTransformSupplier(wordCountsStore.name()), wordCountsStore.name())
                .peek((k, s) -> System.out.printf("After transform: %s, value: %s\n", k, s));
        // writing this source to another kafka topic "streams-pipe-output"
        source.to("streams-pipe-output");
        // generating the topology
        final Topology topology = builder.build();
        System.out.print(topology.describe());

        // constructing a streams client with the properties and topology
        final KafkaStreams streams = new KafkaStreams(topology, properties);
        final CountDownLatch latch = new CountDownLatch(1);

        // attaching shutdown handler
        Runtime.getRuntime().addShutdownHook(new Thread("streams-shutdown-hook") {
            @Override
            public void run(){
                streams.close();
                latch.countDown();
            }
        });
        try{
            streams.start();
            latch.await();
        } catch (Throwable e){
            System.exit(1);
        }
        System.exit(0);
    }

    private static class SampleTransformSupplier implements TransformerSupplier<String, String, KeyValue<String, String>> {

        final private String stateStoreName;

        public SampleTransformSupplier(String stateStoreName) {
            this.stateStoreName = stateStoreName;
        }

        @Override
        public Transformer<String, String, KeyValue<String, String>> get() {
            return new Transformer<String, String, KeyValue<String, String>>() {


                private KeyValueStore<String, Long> stateStore;

                @SuppressWarnings("unchecked")
                @Override
                public void init(ProcessorContext processorContext) {
                    stateStore = (KeyValueStore<String, Long>) processorContext.getStateStore(stateStoreName);
                }

                @Override
                public KeyValue<String, String> transform(String key, String value) {
                    Long countSoFar = stateStore.get(key);
                    if(countSoFar == null){
                        System.out.print("Initializing count so far. this message should be printed only once");
                        countSoFar = 0L;
                    }
                    countSoFar += value.length();
                    System.out.printf(" Key: %s, Value: %s, Count: %d\n\n", key, value, countSoFar);
                    stateStore.put(key, countSoFar);
                    return KeyValue.pair(key, value);
                }

                @Override
                public void close() {
                    // No need to close as this is handled by kafka.
                }
            };
        }
    }
}