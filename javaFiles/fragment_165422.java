@Override
public void handleMessage(SoapMessage message) {
    _log.info(".... IM HERE INTERCEPTOR");

    HttpServletRequest httpRequest = (HttpServletRequest) message.get(AbstractHTTPDestination.HTTP_REQUEST);

    Message inMessage = message.getExchange().getInMessage();
    MessageInfo mi = (MessageInfo) inMessage.get(MessageInfo.class);
    OperationInfo operationInfo = mi.getOperation();

    _log.info("username:: " + httpRequest.getHeader("username"));
    _log.info("password:: " + httpRequest.getHeader("password"));

    if (operationInfo != null) {
        _log.info("operationInfo:: " + operationInfo.getInputName());
    }
}