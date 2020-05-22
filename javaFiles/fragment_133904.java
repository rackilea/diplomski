MongoReplicaSetStatusLogger mongoReplicaSetStatusLogger = new MongoReplicaSetStatusLogger();

// periodically ...
MongoClient mongoClient = getMongoClient();

MongoDatabase admin = mongoClient.getDatabase("admin");
BsonDocument commandResult = admin.runCommand(new BsonDocument("replSetGetStatus", new BsonInt32(1)), BsonDocument.class);
mongoReplicaSetStatusLogger.report(commandResult);