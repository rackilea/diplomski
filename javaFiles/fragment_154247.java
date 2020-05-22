// create the nested aggregation
NestedBuilder nestedAgg = AggregationBuilders.nested("nested_agg").path("myProperty");

// now add each of your sub-aggregation to it
nestedAgg.subAggregation(AggregationBuilders.terms("sibling_agg_1").field("field1"));
nestedAgg.subAggregation(AggregationBuilders.terms("sibling_agg_2").field("field2"));
nestedAgg.subAggregation(AggregationBuilders.terms("sibling_agg_3").field("field3"));

// finally add the nested aggregation to the filter aggregation
client.prepareSearch(index)
    .setTypes(types)
    .setSearchType(SearchType.COUNT)
    .addAggregation(myFilterAggregation
      .subAggregation(nestedAgg);