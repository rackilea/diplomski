ApplicationContext ctx =
            new AnnotationConfigApplicationContext(SpringMongoConfig.class);
    MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

    BasicDBList pipeline = new BasicDBList();
    String[] multiplier = { "$price", "$quantity" };

    pipeline.add(
        new BasicDBObject("$group",
            new BasicDBObject("_id",
                new BasicDBObject("month", new BasicDBObject("$month", "$date"))
                    .append("day", new BasicDBObject("$dayOfMonth", "$date"))
                    .append("year", new BasicDBObject("$year", "$date"))
            )
            .append("totalPrice", new BasicDBObject(
                "$sum", new BasicDBObject(
                    "$multiply", multiplier
                )
            ))
            .append("averageQuantity", new BasicDBObject("$avg", "$quantity"))
            .append("count",new BasicDBObject("$sum",1))
        )
    );

    BasicDBObject aggregation = new BasicDBObject("aggregate","collection")
        .append("pipeline",pipeline);

    System.out.println(aggregation);

    CommandResult commandResult = mongoOperation.executeCommand(aggregation);