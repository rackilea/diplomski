String getApproximateReceiveCount() {
    var receiveMessageRequest = ReceiveMessageRequest.builder()
        .queueUrl("https://sqs.eu-west-1.amazonaws.com/012345678910/my-example-queue")
        .attributeNamesWithStrings(MessageSystemAttributeName.APPROXIMATE_RECEIVE_COUNT.toString())
        .build();
    var sqsClient = SqsClient.builder().endpointOverride(URI.create("http://localhost:4576")).build();
    var response = sqsClient.receiveMessage(receiveMessageRequest);
    var message = response.messages().get(0);
    return message.attributes().get(MessageSystemAttributeName.APPROXIMATE_RECEIVE_COUNT);
}