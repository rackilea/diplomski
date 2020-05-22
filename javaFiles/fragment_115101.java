String query = "{\"constant_score\" : "
                        + "{ \"filter\" : "
                            + "{\"bool\" : "
                                + "{\"must\" : "
                                        + "[{ \"term\" : {\"userId\" : " + userID + "}}, "
                                        + "{ \"range\" :{\"logDate\" : { \"gte\" : \"" + startdate + "\", \"lte\" :  \"" + enddate + "\" }}}]"
                                    + "}"
                                + "}"
                            + "}"
                        + "}";

        SearchResponse res = client.prepareSearch(xxxx).setTypes(yyyy)                  
                .setQuery(query).addAggregation(
                        AggregationBuilders.dateHistogram("date_histogram")
                        .field("logDate")
                        .interval(DateHistogramInterval.DAY)
                        .format("dd-MM-yyyy")
                        .minDocCount(0)
                            .subAggregation(AggregationBuilders.filters("info")
                                    .filter(QueryBuilders.termQuery("logAction", "click"))
                                    .filter(QueryBuilders.termQuery("logAction", "view")))
                        ).setSize(0).execute().get();