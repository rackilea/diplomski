try (Transaction tx = database.beginTx()) {
    Node n = database.getNodeById(nodeId);
    String address = (String)n.getProperty("address", null);

    tx.success();
}