public <T> T receiveAndConvert(QueueMessageChannel destination, Class<T> targetClass) throws MessagingException {
    Message<?> message = destination.receive();
    if (message != null) {
        return (T) getMessageConverter().fromMessage(message, targetClass);
    } else {
        return null;
    }
}