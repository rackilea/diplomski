aggCols.add(expr("sum(expend1)"));
addCols.add(expr("sum(expend2)"));

 dataset.select.(col("col1"),col("col2"),col("expend"))
.groupBy(col("col1"),col("col2"))
.agg(aggCols.get(0), JavaConverters.asScalaIteratorConverter(aggCols.subList(1,aggCols.size()).iterator()).asScala().toSeq());