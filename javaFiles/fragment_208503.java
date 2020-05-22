public T processMessage(Message<?> message) {
    try {
        return this.delegate.process(message);
    }
    catch (Exception e) {
        throw new MessageHandlingException(message, e);
    }
}