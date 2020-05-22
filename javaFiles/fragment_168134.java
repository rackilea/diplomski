BasicDBList inArgs = new BasicDBList();
    inArgs.add("michael");
    inArgs.add("jordan");

    DBObject match = new BasicDBObject("$match",
        new BasicDBObject("name",
           new BasicDBObject("$in", inArgs )
        )
    );

    DBObject group = new BasicDBObject("$group",
        new BasicDBObject("_id","$game.id").append(
            "count", new BasicDBObject("$sum",1)
        )
    );