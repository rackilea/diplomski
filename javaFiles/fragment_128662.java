public class MongoDb {

static Mongo m = new Mongo("127.0.0.1");
DB db;
DBCollection coll;

public MongoDb(String collection){
    db = m.getDB( "game" );
    //...