final Neo4jTestServer server = Neo4jTestServer.getInstance();
Runtime.getRuntime().addShutdownHook(new Thread() {
    @Override
    public void run() {
        server.shutdown();
    }
});