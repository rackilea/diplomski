Aggregation aggr = newAggregation(
        match(Criteria.where("participants").regex(Pattern.compile(userid))),
        unwind("messages"),
        match(new Criteria().orOperator(Criteria.where("messages.touserId").is(userid), Criteria.where("messages.fromuserId").is(userid))),
        sort(Direction.DESC, "messages.lastModifiedDate"),
        group("_id").push("messages").as("messages"),
        project("_id").and("messages").project("slice", 1));