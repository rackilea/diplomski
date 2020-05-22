public static void checkMongoOperations(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
        MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate"); 

        AggregationOperation match = Aggregation.match(Criteria.where("country").is("tiro"));
        AggregationOperation unwind = Aggregation.unwind("myDetails");
        AggregationOperation match2 = Aggregation.match(Criteria.where("myDetails.type").is("health"));
        AggregationOperation sort = Aggregation.sort(Sort.Direction.ASC, "myDetails.datetime");
        AggregationOperation limit = Aggregation.limit(1);

        Aggregation aggregation = Aggregation.newAggregation(match, unwind, match2, sort, limit);
        System.out.println("Aggregation = "+aggregation);
        AggregationResults<AggregateFactoryResult> output = mongoOperation.aggregate(aggregation, "gui_data", AggregateFactoryResult.class);
        System.out.println("output = "+output.getMappedResults().get(0).getCountry());
    }