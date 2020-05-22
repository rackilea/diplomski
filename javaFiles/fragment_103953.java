public TermsBuilder getClassifierAggregation(String classifierName) {
    String probailityField = classifierName + "_probability";
    return AggregationBuilders.terms("by_class").field(classifierName)
        .subAggregation(
            AggregationBuilders.avg("avg_probability").field(probailityField)
        )
        .subAggregation(
            AggregationBuilders.sum("sum_probability").field(probailityField)
        );
}