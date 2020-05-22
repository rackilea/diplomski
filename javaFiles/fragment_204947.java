public Boolean getOrderGiftCardCount(Integer quantity) {

        MongoOperations mongoOperations = getMongoConnection();

        MatchOperation match = new MatchOperation(Criteria.where("quantity").gt(quantity));
        GroupOperation group = Aggregation.group("giftCard").sum("giftCard").as("count");

        Aggregation aggregate = Aggregation.newAggregation(match, group);

        AggregationResults<Order> orderAggregate = mongoOperations.aggregate(aggregate,
                "order", Order.class);

        if (orderAggregate != null) {
            System.out.println("Output ====>" + orderAggregate.getRawResults().get("result"));
            System.out.println("Output ====>" + orderAggregate.getRawResults().toMap());
        }

        return true;

    }