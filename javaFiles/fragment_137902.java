MongoClient mongo = new MongoClient();
DB db = mongo.getDB("datarepo");

DBCollection collection = db.getCollection("rawdata");

db.eval("db.rawdata.find( { BOOKING_CREATED_DATE : { $type : 2 } } ).forEach(function(element){" +
                "element.BOOKING_CREATED_DATE = ISODate(element.BOOKING_CREATED_DATE);" +
                "db.rawdata.save(element);})")