rddPaired.cache();

// groupFilterFunc will filter which items need grouping
JavaPairRDD<Key, Iterable<String>> rddGrouped = rddPaired.filter(groupFilterFunc).groupByKey();
// processGroupedValuesFunction should call `operation` on group of all values with the same key and return the result
rddGrouped.mapValues(processGroupedValuesFunction);

// nogroupFilterFunc will filter which items don't need grouping
JavaPairRDD<Key, Iterable<String>> rddNoGrouped = rddPaired.filter(nogroupFilterFunc);
// processNoGroupedValuesFunction2 should call `operation` on a single value and return the result
rddNoGrouped.mapValues(processNoGroupedValuesFunction2);