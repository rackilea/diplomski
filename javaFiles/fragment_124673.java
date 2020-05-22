public static void main(String[] args) throws ServiceException {

    String namespace        = "namespace";
    String sharedKeyName    = "keyName";
    String sharedSecretKey  = "secretKey";
    String queueName        = "queueName";      

    // Azure Service Bus Service
    Configuration config = ServiceBusConfiguration.configureWithSASAuthentication(namespace, sharedKeyName, sharedSecretKey, ".servicebus.windows.net");
    ServiceBusContract service = ServiceBusService.create(config);

    // Receive and Delete Messages from DLQ
    ReceiveMessageOptions opts = ReceiveMessageOptions.DEFAULT;
    opts.setReceiveMode(ReceiveMode.RECEIVE_AND_DELETE);

    while (true) {
        // To get messages from the DLQ we just need the "$DeadLetterQueue" URI
        ReceiveQueueMessageResult resultQM = service.receiveQueueMessage(queueName + "/$DeadLetterQueue", opts);
        BrokeredMessage message = resultQM.getValue();
        if (message != null && message.getMessageId() != null) {
            System.out.println("MessageID: " + message.getMessageId());
        } else {
            System.out.println("No more messages.");
            break;
        }
    }
}