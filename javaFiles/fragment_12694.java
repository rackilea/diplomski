public void prepare(@SuppressWarnings("rawtypes") Map config, TopologyContext context,
            OutputCollector collector) {
     emf = Persistence.createEntityManagerFactory("cassandra_pu");
     em = emf.createEntityManager();
     database = new DatabaseController(em);
     this.collector = collector;
    }