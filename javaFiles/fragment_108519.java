RestGraphDatabse db = new RestGraphDatabase("http://localhost:7474/db/data",username,password);
Transaction tx = db.beginTx();
try {
    Node node = db.createNode();
    node.setPropery("key", "value");
    tx.success();
} finally {
    tx.finish();
}