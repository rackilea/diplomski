SumAggregationBuilder sum = AggregationBuilders.sum("my_sum")
    .field("amount_field");

MovAvgPipelineAggregationBuilder mavg = PipelineAggregatorBuilders.movingAvg("my_mov_avg", "my_sum");

DateHistogramBuilder histo = AggregationBuilders.dateHistogram("histo")
     .field("date_field")
     .subAggregation(sum)
     .subAggregation(mavg);