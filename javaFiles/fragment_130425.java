for (;;) {
    ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(myQueueUrl);
    List<Message> messages = sqs.receiveMessage(receiveMessageRequest).getMessages();
    for (Message message : messages) {
        System.out.println(" Message");
        System.out.println(" MessageId: " + message.getMessageId());
        System.out.println(" ReceiptHandle: " + message.getReceiptHandle());
        System.out.println(" MD5OfBody: " + message.getMD5OfBody());
        System.out.println(" Body: " + message.getBody());
        for (Entry<String, String> entry : message.getAttributes().entrySet()) {
            System.out.println(" Attribute");
            System.out.println(" Name: " + entry.getKey());
            System.out.println(" Value: " + entry.getValue());
        }
    }
    System.out.println();
}