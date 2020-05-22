package com.app.components;

@Component
public class Neo4jWarmup {

    private static final Logger LOG = LogManager.getLogger(StartupTasks.class);

    @Autowired
    GraphDatabaseService db;

    /*
     * this did the trick - the method gets called 
     * after Spring initialization and the DB works as expected
     */
    @Autowired 
    public void neo4jWarmup() {
        executeTestSelect();
    }

    private void executeTestSelect() {
        LOG.info("Warming up Neo4j...");

        Transaction tx = db.beginTx();
        db.execute("CALL apoc.warmup.run()");
        tx.close();

        LOG.info("Warmup complete.");
    }
}