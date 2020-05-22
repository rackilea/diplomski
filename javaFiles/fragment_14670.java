public class TestTopology {

    public static void main(String[] args) {

        String zkIp = "192.168.59.103";

        String nimbusHost = "192.168.59.103";

        String zookeeperHost = zkIp +":2181";

        ZkHosts zkHosts = new ZkHosts(zookeeperHost);

        SpoutConfig kafkaConfig = new SpoutConfig(zkHosts, "myKafkaTopic", "", "storm");

        kafkaConfig.scheme = new SchemeAsMultiScheme(new JsonScheme() {
            @Override
            public Fields getOutputFields() {
                return new Fields("events");
            }
        });

        KafkaSpout kafkaSpout = new KafkaSpout(kafkaConfig);

        TopologyBuilder builder = new TopologyBuilder();

        builder.setSpout("eventsEmitter", kafkaSpout, 8);

        builder.setBolt("eventsProcessor", new RollingCountBolt(2, 1), 8)
                .fieldsGrouping("requestsEmitter", new Fields("request"));

        //More bolts stuffzz

        Config config = new Config();

        config.setMaxTaskParallelism(5);
        config.put(Config.TOPOLOGY_TICK_TUPLE_FREQ_SECS, 2);
        config.put(Config.NIMBUS_HOST, nimbusHost);
        config.put(Config.NIMBUS_THRIFT_PORT, 6627);
        config.put(Config.STORM_ZOOKEEPER_PORT, 2181);
        config.put(Config.STORM_ZOOKEEPER_SERVERS, Arrays.asList(zkIp));

        try {
            StormSubmitter.submitTopology("my-topology", config, builder.createTopology());
        } catch (Exception e) {
            throw new IllegalStateException("Couldn't initialize the topology", e);
        }
    }

}