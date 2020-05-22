directKafkaStream.foreachRDD(rdd ->{
    rdd.foreachPartition(it -> {

        // Opens only 1 connection per partition
        MongoClient mongo = new MongoClient ("localhost:27017");
        MongoDatabase database = mongo.getDatabase("DB");
        MongoCollection<Document> collection = database.getCollection("collection");

        while (it.hasNext()) {
            byte[] encodedAvroData = it.next()._2;
            LocationType t = deserialize(encodedAvroData);

            Document myDoc = collection.find(eq("key", 4)).first();
            System.out.println(myDoc);
        }

        mongo.close();
    });
});