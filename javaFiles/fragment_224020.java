protected Object handleRequestMessage(Message<?> message) {
    try {
        return this.transformer.transform(message);
    }
    catch (Exception e) {
        if (e instanceof MessageTransformationException) {
            throw (MessageTransformationException) e;
        }
        throw new MessageTransformationException(message, "Failed to transform Message", e);
    }
}