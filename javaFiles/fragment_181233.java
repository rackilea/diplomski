DBObject myGroup = (DBObject)new BasicDBObject(
        "$group", new BasicDBObject(
            "_id","$_id"
        ).append(
            "sent", new BasicDBObject(
                "$sum", new BasicDBObject(
                    "$cond", new Object[]{
                        new BasicDBObject(
                            "$eq", new Object[]{ "$messages.status", "sent"}
                        ),
                        1,
                        0
                    }
                )
            )
        ).append(
            "pending", new BasicDBObject(
                "$sum", new BasicDBObject(
                    "$cond", new Object[]{
                        new BasicDBObject(
                            "$eq", new Object[]{ "$messages.status", "pending"}
                        ),
                        1,
                        0
                    }
                )
             )
        ).append(
            "done", new BasicDBObject(
                "$sum", new BasicDBObject(
                    "$cond", new Object[]{
                         new BasicDBObject(
                            "$eq", new Object[]{ "$messages.status", "done"}
                         ),
                         1,
                         0
                    }
                 )
            )
        )
     );


   ObjectId myId = new ObjectId("545b9fa0dd5318a4285f7ce7");

   Aggregation aggregation = newAggregation(
           match(Criteria.where("_id").is(myId)),
           unwind("messges"),
           new CustomGroupOperation(myGroup)
   );