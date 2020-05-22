Aggregation agg = Aggregation.newAggregation(
        Aggregation.match(
                Criteria.where("mailBoxId").is("1").and("isHidden").is(false)),
        Aggregation.group("$mailBoxId").sum("$unReadMessagesCount").as("unReadMessagesCount")
    );


System.out.println("Query  ==>>["+agg.toString()+"]");
AggregationResults<AggResultObj> data = mongoTemplate.aggregate(agg, "collectionName", AggResultObj.class);

System.out.println("UnReadMesasgeCode :"+data.getUniqueMappedResult().getUnReadMessagesCount());