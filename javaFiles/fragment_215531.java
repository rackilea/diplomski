Source<Message, NotUsed> jmsSource = JmsSource.create(JmsSourceSettings
    .create(connectionFactory)
    .withQueue("test")
    .withAcknowledgeMode(AcknowledgeMode.ClientAcknowledge())
);

CompletionStage<List<String>> result = jmsSource
    .take(msgsIn.size())
    .map(message -> {
        String text = ((ActiveMQTextMessage)message).getText();
        message.acknowledge();
        return text;
    })
    .runWith(Sink.seq(), materializer);