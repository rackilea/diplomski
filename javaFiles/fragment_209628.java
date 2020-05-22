public boolean handleFault(SOAPMessageContext context) {
    SOAPMessage m = context.getMessage();
    if(m != null) {
        SOAPBody body = m.getSOAPBody();
        SOAPFault fault = body.getFault();
        setAbcFault(fault, context);
    }
}

private void setAbcFault(SOAPFault fault, MessageContext context) {
    ByteArrayInputStream bis = (ByteArrayInputStream)context.get("TRANSPORT_IN");
    // do sax parsing on the input stream
    fault.setFaultCode(abcFaultCodeQName);
    fault.setFaultString(abcFaultString);
}