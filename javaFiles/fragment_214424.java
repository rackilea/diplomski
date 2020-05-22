Aggregation aggregation = newAggregation(
            unwind("folderIds"),
            group("folderIds")
                .push(
                    new BasicDBObject("assets_id","$_id")
                     .append("display_name","$displayName")
                ).as("assets")
    );