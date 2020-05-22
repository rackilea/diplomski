MongoClient m = new MongoClient("localhost");
DB db = m.getDB( "test" );
DBCollection coll = db.getCollection( "bulk" );
coll.drop();
coll.createIndex(new BasicDBObject("i", 1), new BasicDBObject("unique", true));

BulkWriteOperation bulkWrite = coll.initializeUnorderedBulkOperation();

for (int i = 0; i < 100; i++) {
    bulkWrite.insert(new BasicDBObject("i", i));
}
// Now add 10 documents to the batch that will generate a unique index error
for (int i = 0; i < 10; i++) {
    bulkWrite.insert(new BasicDBObject("i", i));
}

BulkWriteResult result = null;
List<BulkWriteError> errors = null;
try {
    result = bulkWrite.execute();
} catch (BulkWriteException bwe) {
    bwe.printStackTrace();
    errors = bwe.getWriteErrors();
    result = bwe.getWriteResult();
}

for (BulkWriteError e : errors) {
    System.out.println(e.getIndex() + " failed");
}

System.out.println(result);