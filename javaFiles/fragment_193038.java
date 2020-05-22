BasicDBObject doc = new BasicDBObject("doc",new BasicDBObject("job","Design Engineer").append("place","Bengaluru").append("salary", "40K USD"));
    BasicDBObject query = new BasicDBObject();
    query.put("_id","abc@gmail.com");
    BasicDBObject set = new BasicDBObject("$set", doc);
    collection.update(query, set);

// result doc
{
    "_id" : "abc@gmail.com",
    "Password" : "xyz",
    "first_name" : "ABC",
    "last_name" : "PQR",
    "doc" : {
        "job" : "Design Engineer",
        "place" : "Bengaluru",
        "salary" : "40K USD",
    }
}