// Create AdminClient
Properties props = new Properties();
props.load(new FileInputStream("ac.properties"));
AdminClient adminClient = KafkaAdminClient.create(props);

// Get brokers' details 
DescribeClusterResult describeClusterResult = adminClient.describeCluster();
List<Node> brokers = new ArrayList<>(describeClusterResult.nodes().get());
for (Node broker : brokers) {
    System.out.println("Host=" + broker.host() + ", Port=" + broker.port());
}