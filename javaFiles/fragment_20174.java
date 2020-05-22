protected String getMethodName(MessageContext mc)
    {
    String operationName = null;

    try
    {
    SOAPMessageContext messageContext = (SOAPMessageContext) mc;

    // assume the operation name is the first element
    // after SOAP:Body element
    Iterator i = messageContext.
    getMessage().getSOAPPart().getEnvelope().getBody().getChildElements();
    while ( i.hasNext() )
    {
    Object obj = i.next();
    if(obj instanceof SOAPElement)
    {
    SOAPElement e = (SOAPElement) obj;
    operationName = e.getElementName().getLocalName();
    break;
    }
    }
    }
    catch(Exception e)
    {
    e.printStackTrace();
    }
    return operationName;
    }