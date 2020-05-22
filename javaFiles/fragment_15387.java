public abstract class MessageEncoder<T extends Message> {
    protected MessageEncoder(Class<? extends T> messageClass) {
      GameConstants.RELEASE.register(messageClass, this);
    }

    /**
     * Get the encoded message to send to the client.
     * 
     * @param message The message.
     * @return the {@link GamePacket} ready to be sent.
     */
    public abstract GamePacket encode(T message);
}