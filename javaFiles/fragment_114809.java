AmazonDynamoDB dynamoDBClient = AmazonDynamoDBClientBuilder.standard().build();
    AWSCredentialsProvider credentialsProvide = new DefaultAWSCredentialsProviderChain();
    AmazonDynamoDBClientBuilder clientBuilder = AmazonDynamoDBClientBuilder.standard();
    clientBuilder.setCredentials(credentialsProvide);

    EndpointConfiguration endpointConfiguration = new EndpointConfiguration("http://localhost:8000/", "local");
    clientBuilder.setEndpointConfiguration(endpointConfiguration);
    dynamoDBClient = clientBuilder.build();