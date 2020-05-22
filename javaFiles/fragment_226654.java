Aggregation agg = newAggregation(match(Criteria.where("device_datetime").exists(true)
        .andOperator(
            Criteria.where("device_datetime").gte(startDate),
            Criteria.where("device_datetime").lte(endDate))),
    group(Fields.fields().and("fc", "$fc").and("vehicle_name", "$vehicle_name").and("device_id", "$device_id"))
    .count().as("count"));