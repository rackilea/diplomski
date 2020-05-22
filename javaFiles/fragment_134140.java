// Run mapReduce on collectionName
String map = "function () { for (var key in this) { emit(key, null); } }";
String reduce = "function () {}";
MapReduceResults<ValueObject> results = mongoTemplate.mapReduce(
    "collectionName", 
    map, 
    reduce,
    new MapReduceOptions().outputCollection("col_out"), 
    ValueObject.class
);
// Get the distinct keys from output collection col_out ---
List<String> fieldsSuperset = mongoTemplate.getCollection("col_out").distinct("_id");