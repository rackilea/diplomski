package test.barry;

public class Main {

        public static void main(String[] args) {
                com.mongodb.client.MongoDatabase db = connectToClusterStandAlone();
                InsertArrayItem(db);

                return;
        }


        private static void InsertArrayItem(com.mongodb.client.MongoDatabase db) {
                System.out.println("");
                System.out.println("Starting InsertArrayItem...");

                com.mongodb.client.MongoCollection<org.bson.Document> collection = db.getCollection("people");

                com.mongodb.client.MongoCursor<org.bson.Document> cursor = collection.find(com.mongodb.client.model.Filters.eq("testfield", true)).sort(new org.bson.Document("review_date", -1)).limit(1).iterator();

                if(cursor.hasNext()) {
                        org.bson.Document document = cursor.next();
                        Object id = document.get("_id");

                        System.out.println("Selected Id: " + id.toString());

                        org.bson.Document newDocument = new org.bson.Document("somekey", "somevalue");

                        collection.findOneAndUpdate(
                                com.mongodb.client.model.Filters.eq("_id", id),
                                new org.bson.Document("$push", new org.bson.Document("myarray", newDocument))
                        );  
                }   


                System.out.println("Completed InsertArrayItem.");
        }

        private static com.mongodb.client.MongoDatabase connectToClusterStandAlone() {
                // STANDALONE STILL REQUIRES HOSTS LIST WITH ONE ELEMENT...
                // http://mongodb.github.io/mongo-java-driver/3.9/javadoc/com/mongodb/MongoClientSettings.Builder.html

                java.util.ArrayList<com.mongodb.ServerAddress> hosts = new java.util.ArrayList<com.mongodb.ServerAddress>();
                hosts.add(new com.mongodb.ServerAddress("127.0.0.1", 27017));

                com.mongodb.MongoCredential mongoCredential = com.mongodb.MongoCredential.createScramSha1Credential("testuser", "admin", "mysecret".toCharArray());

                com.mongodb.MongoClientSettings mongoClientSettings = com.mongodb.MongoClientSettings.builder()
                        .applyToClusterSettings(clusterSettingsBuilder -> clusterSettingsBuilder.hosts(hosts))
                        .credential(mongoCredential)
                        .writeConcern(com.mongodb.WriteConcern.W1)
                        .readConcern(com.mongodb.ReadConcern.MAJORITY)
                        .readPreference(com.mongodb.ReadPreference.nearest())
                        .retryWrites(true)
                        .build();

                com.mongodb.client.MongoClient client = com.mongodb.client.MongoClients.create(mongoClientSettings);
                com.mongodb.client.MongoDatabase db = client.getDatabase("test");

                return db;
        }
}