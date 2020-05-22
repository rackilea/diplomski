@Override
public Message<?> preSend(Message<?> message, MessageChannel channel) {

    Message<?> newMessage = MessageBuilder.createMessage(modifyMessage(message),
    headerAccessor.getMessageHeaders());
    return message;
    ...
}