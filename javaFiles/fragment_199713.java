SearchResponse response = client.prepareSearch()
        .addAggregation(AggregationBuilders.avg("AvgTT").field("action_time"))
        .addAggregation(AggregationBuilders.avg("AvgST").field("st"))
        .addAggregation(AggregationBuilders.avg("AvgCALC").field("ncalc"))
        .addAggregation(AggregationBuilders.avg("AvgRC").field("rc"))
        .addAggregation(AggregationBuilders.avg("AvgFR").field("st"))
        .execute()
        .actionGet();