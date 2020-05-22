// your code
TermsBuilder yearAgg = AggregationBuilders.terms("by_year")
    .field("year").subAggregation(AggregationBuilders.terms("by_name")).field("Name").subAggregation(sumMarks);
                                                                      ^
                                                                      |
                                             This parenthesis is wrong, it should go at the end