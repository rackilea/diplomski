// same as your code
TermFilterBuilder family_filter_1 = ...;
FilteredQueryBuilder qbuilder = ...;
SearchRequestBuilder search = ...;

// build the range filter
RangeQuery ageRange = QueryBuilders.rangeQuery("age")
    .from(18).to(40).includeLower(false).includeUpper(false);

// build the terms sub-aggregation
TermsAggregation age = AggregationBuilders.terms("age")
    .field("age") 
    .size(0)
    .order(Terms.Order.count(true));

// build the filter top-aggregation
FilterAggregationBuilder youngAge = AggregationBuilders
    .filter("young_age")
    .filter(ageRange)
    .subAggregation(age);


search.addAggregation(youngAge);