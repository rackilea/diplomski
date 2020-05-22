public enum Cassandra {

        DB;

        private Session session;
        private Cluster cluster;
        private static final Logger LOGGER = LoggerFactory.getLogger(Cassandra.class);

        /**
         * Connect to the cassandra database based on the connection configuration provided.
         * Multiple call to this method will have no effects if a connection is already established
         * @param conf the configuration for the connection
         */
        public void connect(ConnectionCfg conf) {
            if (cluster == null && session == null) {
                cluster = Cluster.builder().withPort(conf.getPort()).withCredentials(conf.getUsername(), conf.getPassword()).addContactPoints(conf.getSeeds()).build();
                session = cluster.connect(conf.getKeyspace());
            }
            Metadata metadata = cluster.getMetadata();
            LOGGER.info("Connected to cluster: " + metadata.getClusterName() + " with partitioner: " + metadata.getPartitioner());
            metadata.getAllHosts().stream().forEach((host) -> {
                LOGGER.info("Cassandra datacenter: " + host.getDatacenter() + " | address: " + host.getAddress() + " | rack: " + host.getRack());
            });
        }

        /**
         * Invalidate and close the session and connection to the cassandra database
         */
        public void shutdown() {
            LOGGER.info("Shutting down the whole cassandra cluster");
            if (null != session) {
                session.close();
            }
            if (null != cluster) {
                cluster.close();
            }
        }

        public Session getSession() {
            if (session == null) {
                throw new IllegalStateException("No connection initialized");
            }
            return session;
        }
}