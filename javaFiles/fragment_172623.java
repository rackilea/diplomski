@Override
public Message<String> receive() {
    return this.receive(0);
}

@Override
public Message<String> receive(long timeout) {
    ReceiveMessageResult receiveMessageResult = this.amazonSqs.receiveMessage(
            new ReceiveMessageRequest(this.queueUrl).
                    withMaxNumberOfMessages(1).
                    withWaitTimeSeconds(Long.valueOf(timeout).intValue()).
                    withAttributeNames(ATTRIBUTE_NAMES).
                    withMessageAttributeNames(MESSAGE_ATTRIBUTE_NAMES));
    if (receiveMessageResult.getMessages().isEmpty()) {
        return null;
    }
    com.amazonaws.services.sqs.model.Message amazonMessage = receiveMessageResult.getMessages().get(0);
    Message<String> message = createMessage(amazonMessage);
    this.amazonSqs.deleteMessage(new DeleteMessageRequest(this.queueUrl, amazonMessage.getReceiptHandle()));
    return message;
}