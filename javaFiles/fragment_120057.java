public static void main(String[] args) {

        MongoClient mongoClient = null;
        MongoCredential mongoCredential = MongoCredential.createScramSha1Credential("dbAdminUser", "test",
                "password".toCharArray());

        mongoClient = new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(mongoCredential));

        DB db = mongoClient.getDB("test");

        DBCursor dbCursor = db.getCollection("Account").find();

        while (dbCursor.hasNext()) {
            DBObject dbObject = dbCursor.next();
            System.out.println(dbObject);
            db.getCollection("AccountCapped").insert(dbObject);         
        }

        mongoClient.close();

    }