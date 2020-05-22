Properties props = new Properties();
props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
try (AdminClient client = AdminClient.create(props)) {
    ListTopicsOptions options = new ListTopicsOptions();
    options.listInternal(true); // includes internal topics such as __consumer_offsets
    ListTopicsResult topics = client.listTopics(options);
    Set<String> currentTopicList = topics.names().get();
    // do your filter logic here......
}