MongoClientUri uri = new MongoClientUri("mongodb://heroku_app1234:random_password@ds029017.mongolab.com:29017/heroku_app1234");
MongoClient client = new MongoClient(uri);
Jongo jongo = new Jongo(client.getDB(uri.getDatabase()));
MongoCollection collection = jongo.getCollection("myCollection");
collection.save(someBean);
client.close();