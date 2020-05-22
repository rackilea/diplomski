MessageContext messageContext = context.getMessageContext();

    if (messageContext == null || !(messageContext instanceof WrappedMessageContext)) {

        return null;

    }
    Message message = ((WrappedMessageContext) messageContext).getWrappedMessage();

    List<Header> headers = CastUtils.cast((List<?>) message.get(Header.HEADER_LIST));

    return headers;

}