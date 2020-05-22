String letFilter = "{\n" +
    "\t$let: {\n" +
    "\t\tvars: {\n" +
    "\t\t\tlogTimeMax: {\n" +
    "\t\t\t\t$max: \"$result.logTime\"\n" +
    "\t\t\t}\n" +
    "\t\t},\n" +
    "\t\tin: {\n" +
    "\t\t\t$filter: {\n" +
    "\t\t\t\tinput: \"$result\",\n" +
    "\t\t\t\tas: \"result\",\n" +
    "\t\t\t\tcond: {\n" +
    "\t\t\t\t\t$eq: [\"$$result.logTime\", '$$logTimeMax']\n" +
    "\t\t\t\t}\n" +
    "\t\t\t}\n" +
    "\t\t}\n" +
    "\t}\n" +
    "}";

 List<Document> results = collection.aggregate(Arrays.asList(Aggregates.group("$sourceSystemName", push("result", new Document("_id", "$id").
                        append("logID", "$logID").
                        append("type", "$type").
                        append("logTime", "$logTime") )), Aggregates.project(new Document("result", Document.parse(letFilter)))
        )).into(new ArrayList<>());