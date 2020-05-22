@Retryable(maxAttempts = 10, value = KafkaSendException.class)
public Response post(Message message) throws FailedToPostException{
ListenableFuture<SendResult<String, Message>> future = kafkaTemplate.send("topicName", message);

    try {
        future.get(1. TimeUnit.SECONDS);
    } catch(SomeException ex) {
        LOGGER.error("Message Post Failed. '{}'", ex.getCause().getMessage(), ex);
        throw ex;
    }

    LOGGER.info("Post Finished. '{}' with offset: {}", message,
                        result.getRecordMetadata().offset());

}