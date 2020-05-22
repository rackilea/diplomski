public void connect(String nodes, String username, String password, String keyspace) {

    cluster = Cluster.builder()
     .addContactPoints(nodes.split(","))
     .withCredentials(username, password)
     .build();

session = cluster.connect(keyspace);

Metadata metadata = cluster.getMetadata();

System.out.printf("Connected to cluster: %s\n",
      metadata.getClusterName());

for ( Host host : metadata.getAllHosts() ) {
   System.out.printf("Datacenter: %s; Host: %s; Rack: %s\n",
      host.getDatacenter(), host.getAddress(), host.getRack());
 }
}