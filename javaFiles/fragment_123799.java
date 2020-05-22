List<Document> results = 
            collection.aggregate(
        Arrays.asList(
                Aggregates.group(
                        "$sourceSystemName",
                         max("logTime", "$logTime"),
                         push("result",
                                new Document("_id", "$id").
                                        append("logID", "$logID").
                                        append("type", "$type").
                                        append("logTime", "$logTime"))
                ),
                Aggregates.project(
                        fields(include("logTime"),
                                new Document("result",
                                        new Document("$setDifference",
                                                Arrays.asList(
                                                        new Document("$map",
                                                                new Document("input", "$result").
                                                                        append("as", "result").
                                                                        append("in",
                                                                                new Document("$cond",
                                                                                        Arrays.asList(new Document("$eq", Arrays.asList("$logTime", "$$result.logTime")),
                                                                                                "$$result",
                                                                                                false)
                                                                                )
                                                                        )
                                                        ),
                                                        Arrays.asList(false)
                                                )
                                        )
                                )
                        )
                )
        )
 ).into(new ArrayList<>());