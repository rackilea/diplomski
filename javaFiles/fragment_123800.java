String maxResult =  "{\n" +
  "\t\"$setDifference\": [{\n" +
  "\t\t\t\"$map\": {\n" +
  "\t\t\t\t\"input\": \"$result\",\n" +
  "\t\t\t\t\"as\": \"result\",\n" +
  "\t\t\t\t\"in\": {\n" +
  "\t\t\t\t\t\"$cond\": [{\n" +
  "\t\t\t\t\t\t\t\"$eq\": [\"$logTime\", \"$$result.logTime\"]\n" +
  "\t\t\t\t\t\t},\n" +
  "\t\t\t\t\t\t\"$$result\",\n" +
  "\t\t\t\t\t\tfalse\n" +
  "\t\t\t\t\t]\n" +
  "\t\t\t\t}\n" +
  "\t\t\t}\n" +
  "\t\t},\n" +
  "\t\t[false]\n" +
  "\t]\n" +
  "}";

List<Document> results = collection.aggregate(Arrays.asList(Aggregates.group("$sourceSystemName", max("logTime", "$logTime"), push("result", new Document("_id", "$id").
                append("logID", "$logID").
                append("type", "$type").
                append("logTime", "$logTime") )), Aggregates.project(fields(include("logTime"), new Document("result", Document.parse(maxResult)))
 ))).into(new ArrayList<>());