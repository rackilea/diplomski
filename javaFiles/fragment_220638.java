private MongoCollection<Document> db;
MongoClientURI uri  = new MongoClientURI(MONGO_URL);
MongoClient mongoClient = new MongoClient(uri);
db = mongoClient.getDatabase(uri.getDatabase()).getCollection(COLLECTION_NAME);

Bson query = Filters.eq("accountName", accountName)
Bson projection = Projections.include("password")
FindIterable<Document> iterator = db.find(query).projection(projection)