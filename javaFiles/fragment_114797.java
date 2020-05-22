public class JavaAggregation {
    public static void main(String args[]) throws UnknownHostException {

        MongoClient mongo = new MongoClient();
        DB db = mongo.getDB("test"); // your database name

        DBCollection coll = db.getCollection("collectionName"); // your collection name

        // create the pipeline operations, first with the $match
        Date now = new Date();
        Date start = new Date(now.getYear(), now.getMonth(), now.getDate()-days);
        Date end  = new Date(now.getYear(), now.getMonth(), now.getDate()+1);
        end.setHours(0);
        end.setMinutes(0);
        DBObject match = new BasicDBObject("$match",
                            new BasicDBObject("LAST_UPDATED",
                                new BasicDBObject("$gte", start).append("$lt", end)
                            )
                        );

        // build the $group operations
        DBObject groupFields = new BasicDBObject( "_id", "$USER_NAME");
        groupFields.put("count", new BasicDBObject( "$sum", 1));

        DBObject group = new BasicDBObject("$group", groupFields);
        List<DBObject> pipeline = Arrays.asList(match, group);

        AggregationOutput output = coll.aggregate(pipeline);

        for (DBObject result : output.results()) {
            System.out.println(result);
        }
    }
}