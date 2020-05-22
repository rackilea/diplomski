public final void invoke(MessageContext messageContext) throws Exception {
    WebServiceMessage request = messageContext.getRequest();
    Object requestObject = unmarshalRequest(request);
    if (onUnmarshalRequest(messageContext, requestObject)) {
        Object responseObject = invokeInternal(requestObject);
        if (responseObject != null) {
            WebServiceMessage response = messageContext.getResponse();
            marshalResponse(responseObject, response);
            onMarshalResponse(messageContext, requestObject, responseObject);
        }
    }
}