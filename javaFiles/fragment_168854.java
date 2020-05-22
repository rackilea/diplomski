Aggregation agg = newAggregation(
      new CustomAggregationOperation(
        new BasicDBObject("$group",
            new BasicDBObject("last",
                new BasicDBObject("$last",
                    new BasicDBObject("fisrname","$firstname")
                        .append("lastname","$lastname")
                )
            )
        )
      )
    );