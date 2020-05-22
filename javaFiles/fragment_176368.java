Aggregation agg = newAggregation(
        project("quantity")
            .andExpression("dayOfMonth(date)").as("day")
            .andExpression("month(date)").as("month")
            .andExpression("year(date)").as("year")
            .andExpression("price * quantity").as("totalAmount"),
        group(fields().and("day").and("month").and("year"))
            .avg("quantity").as("averavgeQuantity")
            .sum("totalAmount").as("totalAmount")
            .count().as("count")
    );