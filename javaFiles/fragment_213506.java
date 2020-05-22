public Boolean createOrder(String productName) {

        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(dynamoDBClient);

        Order order = new Order();
        order.setProductName(productName);

        dynamoDBMapper.save(order);


        return true;

    }