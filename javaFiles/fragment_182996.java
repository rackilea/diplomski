public interface BatchMessageListener extends MessageListener {

    @Override
    default void onMessage(Message message) {
        throw new UnsupportedOperationException("Should never be called by the container");
    }

    @Override
    void onMessageBatch(List<Message> messages);

}